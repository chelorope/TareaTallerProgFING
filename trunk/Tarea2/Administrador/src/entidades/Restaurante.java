package entidades;

import dataTypes.DataProducto;
import dataTypes.DataRestaurante;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.imageio.ImageIO;

public class Restaurante extends Usuario{
 
    private Set<String> imagenes;
    private Map<String, Individual> individuales;
    private Map<String, Promocion> promociones;
    private Map<String, Categoria> categorias;
    private float puntajeProm;
    private int cantComentarios;
    private int puntos;

     public Restaurante(String nick, String nom, String dir, String mail, Set<BufferedImage> imgs) throws IOException {
        super(nick, nom, dir, mail);
        promociones = new HashMap<>();
        individuales = new HashMap<>();
        categorias = new HashMap<>();
        
        Set<String> urls = new HashSet<>();
        
        if (imgs != null){
            /* GUARDA LAS IMAGENES */
            String workingDir;
            String uploadFilePath;
            String OS =System.getProperty("os.name").toLowerCase();
            if (OS.contains("win")){
                workingDir = System.getenv("APPDATA");
            }else{
                workingDir = System.getProperty("user.home");
            }
            
                uploadFilePath = workingDir + "/QuickOrder/Restaurantes/" + nick;
                /*Crea la ruta si no existe*/
                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                /*******************/
            int i = 0;
            
            for(BufferedImage img : imgs){
                ImageIO.write(img, "png",new File(uploadFilePath + "/" + nick+ "_" + i + "_restaurante.png"));
                urls.add(uploadFilePath + "/" + nick+ "_" + i + "_restaurante.png");
                i++;
            }   
        }
        
        imagenes = urls;
        puntajeProm = 0;
        cantComentarios = 0;
        puntos = 0;
        
    }
     
    public void crearIndividual(String nombre, String descripcion, int precio, BufferedImage imagen) throws IOException{
        Individual I = new Individual(nombre, descripcion, precio, this, imagen);
        individuales.put(nombre,I);
    }
   
    public void crearPromocion(String nombre, String descripcion, int descuento, int precio, BufferedImage imagen) throws IOException{
        
        Promocion P = new Promocion(nombre, descripcion ,imagen, descuento, this);
        promociones.put(nombre,P);
    }
    
    public Map<String, Individual> getIndividuales(){
        return individuales;                
    }
    
    public Map<String, Promocion> getPromociones(){
        return promociones;                
    }
     
    public boolean existeProducto(String key){
        return (promociones.containsKey(key) || individuales.containsKey(key));
    }
    
    public boolean existeIndividual(String key){
        return (individuales.containsKey(key));
    }
    
    public void agregarCategoria(Categoria cat){
        categorias.put(cat.getNombre(), cat);
    }
    
    public void agregarIndividualAPromocion(String nombreInd, int cantidad, Promocion promo){
        Individual ind;
        ind = individuales.get(nombreInd);
        CantInd CI = new CantInd(cantidad, ind,promo);
        ind.agregarPromoAInd(CI);
        promo.agregarIndAPromo(CI);
    }
    
    public Promocion getPromocion(String key){
        return promociones.get(key);
    }
    public Individual getIndividual(String key){
        return individuales.get(key);
    }
    
    // obtener dataTypes de productos
    public Set<DataProducto> listarProductos(int tipo) throws IOException{        
        Set<DataProducto> sdp = new HashSet<>(); 
        if (tipo == 1 || tipo == 3)
            for(Entry<String, Individual> entry : individuales.entrySet()) {
                String k = entry.getKey();
                Producto v = entry.getValue();
                DataProducto dp = new DataProducto(v.getNombre(),v.getDescripcion(), v.getPrecio(),v.getTipo(),
                        v.getRestaurante().getNombre(),v.getRestaurante().getNickName(),v.getRestaurante().getMail(),
                        v.getImagen(),false,-1, -1 , -1,null,v.listarPedidos()); 
                sdp.add(dp);
            }
        if (tipo == 2 || tipo == 3)
            for(Entry<String, Promocion> entry : promociones.entrySet()) {
                String k = entry.getKey();
                Producto v = entry.getValue();

                DataProducto dp = new DataProducto(v.getNombre(),v.getDescripcion(), v.getPrecio(),v.getTipo(),
                        v.getRestaurante().getNombre(),v.getRestaurante().getNickName(),v.getRestaurante().getMail(),
                        v.getImagen(),v.getActiva(), -1, -1 , -1,null,v.listarPedidos());
                sdp.add(dp);
            }       
        return sdp;        
    }
    
    public DataRestaurante getInfo() throws IOException{
        
        Set<String> cats = new HashSet<>();
        for(Categoria cat:categorias.values() )
         cats.add(cat.getNombre());

        return(new DataRestaurante(nombre, nickname, mail, direccion, imagenes, this.listarProductos(1),this.listarProductos(2),cats,puntajeProm));
    }
    
    public float getPuntaje(){
        return puntajeProm;
    }

    public void setPuntaje(int puntaje){
        cantComentarios = cantComentarios + 1;
        puntos = puntos + puntaje;
        puntajeProm = puntos/cantComentarios;
    }
}

