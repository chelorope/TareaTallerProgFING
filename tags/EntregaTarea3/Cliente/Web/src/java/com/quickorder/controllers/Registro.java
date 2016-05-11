/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickorder.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jasypt.util.password.StrongPasswordEncryptor;
import sun.misc.BASE64Encoder;

@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100)

/**
 * @MultipartConfig
 * @author Mati
 */
public class Registro extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        HttpSession objSesion = request.getSession();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String tipo = request.getParameter("tipo");
        String fnac = request.getParameter("birthday");
        if (tipo == null) {
            tipo = "null";
        } 
        URL url = new URL("http://" + (request.getSession().getAttribute("wsurl") + "/publicadorRegistro?wsdl"));
        publicar.PublicadorRegistroService service = new publicar.PublicadorRegistroService(url);
        publicar.PublicadorRegistro port = service.getPublicadorRegistroPort();
        
        
        switch(tipo){
                
                case "chequearUsuario": 
                    if (port.seleccionarCliente(username)){
                        response.getWriter().write("{ \"valid\": false }");
                    }
                    else response.getWriter().write("{ \"valid\": true }");
                    break; 
                    
                case "chequearMail": 
                    if (port.seleccionarCliente(email)){
                        response.getWriter().write("{ \"valid\": false }");
                    }
                    else response.getWriter().write("{ \"valid\": true }");
                    break;     
                
                case "null":
                    //Da de alta al usuario
                    String str = fnac;
                    String delimiter = "/";
                    String[] temp;
                    temp = str.split(delimiter);
                    String anio = temp[0];
                    String mes = temp[1];
                    String dia = temp[2];
                    
                    int a = Integer.parseInt(anio);
                    int d = Integer.parseInt(dia);
                    int m = Integer.parseInt(mes);
                    //Crea fecha
                    /*********Transforma la imagen a string******/
                    Part part = request.getPart("imagen");
//                    String name = getFileName(part);
                    File imgF = stream2file(part.getInputStream());
                    BufferedImage imgBuff = ImageIO.read(imgF);
                    //Transforma de imageBuffered a string//
                    String imgstr;
                    imgstr = encodeToString(imgBuff, "png");
                    //Se encripta la contraseña
                    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                    String encryptedPassword = passwordEncryptor.encryptPassword(password);
                    /******************************************/
                    port.darDeAltaCliente(username,email,nombre,direccion,apellido,d,m,a,encryptedPassword,imgstr);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/casa");
                    dispatcher.forward(request, response);
                    break;
        }
	
        // redirige a la página principal para que luego rediriga a la página que corresponde
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/casa");
        dispatcher.forward(request, response);*/
    }
    
    public static final String PREFIX = "stream2file";
    public static final String SUFFIX = ".tmp";

    public static File stream2file (InputStream in) throws IOException {
        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }
    
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = "";
        if (image != null){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            try {
                ImageIO.write(image, type, bos);
                byte[] imageBytes = bos.toByteArray();

                BASE64Encoder encoder = new BASE64Encoder();
                imageString = encoder.encode(imageBytes);

                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageString;
    }
        

    



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
