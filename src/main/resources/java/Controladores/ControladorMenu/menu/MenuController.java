
package Controladores.ControladorMenu.menu;

import Controladores.ControladorMenu.AlumnosController.AlumnosInicioController.AlumnosInicioController;
import Controladores.ControladorMenu.AlumnosController.RegistroController.AlumnosRegistroController;
import Controladores.ControladorMenu.Bienvenida.Acerca_deController;
import Controladores.ControladorMenu.Bienvenida.BienvenidaController;
import Controladores.ControladorMenu.Cursos.CursosController;
import Controladores.ControladorMenu.Horarios.HorariosController;
import Controladores.ControladorMenu.Materias.MateriasController;
import Controladores.ControladorMenu.Profesores.ProfesoresInicioController;
import Controladores.ControladorMenu.Profesores.ProfesoresRegistroController;
import Controladores.ControladorMenu.asistencia.AsistenciaControllerInicio;
import Controladores.ControladorMenu.informaciones.configurationController;
import Controladores.Enums.Fxmls;
import Controladores.tabcontrol.TabManipulator;
import Modelos.IO.IOManager;
import Modelos.Pojos.Users.User;
import Modelos.SqliteDaoService.DaoService;
import Servicios.alerta.Alerta;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MenuController implements Initializable { 
    /*
     La clase MenuController es la encargada de manejar la interfaz de usuario del menú principal.
     Esta clase implementa la interfaz Initializable, que es necesaria para inicializar la clase, esto significa
     que se debe llamar al método initialize() para inicializar la clase.
     */
    private Stage st; // se declara una variable tipo Stage, que es una ventana JavaFX

    private TabManipulator tabController; // se declara una variable tipo TabManipulator

    @FXML
    private MenuItem inicio_alumno;

    @FXML
    private MenuItem registro_alumno;

    @FXML
    private MenuItem inicio_profesor;

    @FXML
    private MenuItem registro_profesor;

    @FXML
    private MenuItem inicio_materia;

    @FXML
    private MenuItem inicio_horarios;

    @FXML
    private MenuItem inicio_cursos;

    @FXML
    private MenuItem asistencia_inicio;

    @FXML
    private MenuItem configuracion;

    @FXML
    private MenuItem acerca_de;

    @FXML
    private MenuItem inicio;

    @FXML
    private MenuItem importar;

    @FXML
    private MenuItem exportar;

    @FXML
    private TabPane tabmenu;

    public MenuController(Stage st) {
        this.st = st;
    }

    public void start( ) { // este método se llama para iniciar el controlador
        st.setTitle("Programa de Asistencias "); //título de la ventana
        st.getIcons().add(new Image("/utils/logo/iconoProyecto.png")); //icono de la ventana
        st.sizeToScene();// ajusta el tamaño de la ventana para que se ajuste al contenido
        st.setResizable(false);//evita que la ventana sea redimensionable
        st.setOnCloseRequest(this::salir);//Establece el evento de cierre de la ventana llamando al método salir
        st.show(); //muestra la ventana
    }

    private void salir(WindowEvent event){ // este método se llama cuando se cierra la ventana
        try{
            if(TabManipulator.getCurrentInstance().IsThereTabOpened()){ // verifica si hay alguna pestaña abierta
                if(notifyOpenedTabs()){ // Llama un método que notifica al usuario sobre las pestañas abiertas, si deseaa cerrar las pestañas, se cierran todas.
                    TabManipulator.getCurrentInstance().CloseAll();//Cierra todas las pestañas abiertas
                    Platform.exit();//Cierra la aplicación
                }else{
                    event.consume(); // si no hay pestañas abiertas, se cancela el evento de cierre
                }
            }
        }catch (IllegalAccessException e){ //Captura cualquier error y lo imprime en consola
            e.printStackTrace();
        }
    }

    private boolean notifyOpenedTabs(){ //método que notifica al usuario sobre las pestañas abiertas
        Optional<ButtonType> result = Alerta.CreateAlert(Alert.AlertType.CONFIRMATION, "Advertencia", "Pestañas abiertas... ", "Existen pestañas abiertas" +
                "¿Desea cerrarlas y sallir ?", st);
        return result.get() == ButtonType.OK;
    }
/*
 * Cada uno de estos métodos: Se utiliza para agregar una nueva pestaña a la interfaz de usuario utilizando el tabController. 
El método add toma tres parámetros:
Fxmls: Un enumerador que representa el tipo de vista que se desea cargar.
Clase del controlador: La clase que se encargará de manejar la lógica de la vista.
String: El título que se mostrará en la pestaña.
 */

    private void mostrarAlumnoInicio(){
        tabController.add(Fxmls.INICIO_ALUMNOS,AlumnosInicioController.class, "Alumnos | Inicio");
    }
    private void mostrarRegistroAlumno(){
        tabController.add(Fxmls.ALUMNOS_REGISTRO, AlumnosRegistroController.class, "Alumnos | Registro ");
    }

    private void mostrarProfesorInicion(){
        tabController.add(Fxmls.PROFESOR_INICIO, ProfesoresInicioController.class, "Profesores | Inicio");
    }

    private void mostrarRegistroProfesor(){
        tabController.add(Fxmls.PROFESOR_REGISTRO, ProfesoresRegistroController.class, "Profesores | Registro");
    }
    private void mostrarInicioCursos(){
        tabController.add(Fxmls.CURSOS_INICIO, CursosController.class, "Cursos | Inicio");
    }
    private void mostrarInicioHorario(){
        tabController.add(Fxmls.HORARIO_INICIO, HorariosController.class, "Horarios | Inicio");
    }
    private void mostrarInicioMateria(){
        tabController.add(Fxmls.MATERIA_INICIO, MateriasController.class, "Materias | Inicio");
    }

    private void abrirInicio(){
        tabController.add(Fxmls.BIENVENIDA, BienvenidaController.class, "Bienvenido.");
    }
    private void abrirAcerca_de(){
        tabController.add(Fxmls.ACERCA_DE, Acerca_deController.class, "Acerca de");
    }
    private void mostrarAsistencia(){
        tabController.add(Fxmls.ASISTENCIA_INICIO, AsistenciaControllerInicio.class, "Asistencia | Inicio");
    }
    private void mostrarConfiguracion(){
        tabController.add(Fxmls.CONFIG, configurationController.class, "Configuración");
    }


    private void importar(){
        //se crea un filtro de extensión para que solo se puedan importar archivos con la extensión .db
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Data Base file", "*.db");
        //se crea una instancia que permite al usuario seleccionar archivos
        FileChooser fileChooser = new FileChooser();
        //se agrega el filtro de extensión al filechooser
        fileChooser.getExtensionFilters().add(extFilter);
        //se abre el filechooser para que el usuario pueda seleccionar un archivo, se almacena en la variable file.
        File file = fileChooser.showOpenDialog(st);
        //se verifica si el usuario no seleccionó ningún archivo, si es así, se muestra una alerta informando que no se seleccionó un archivo
        if(Objects.isNull(file)){
            Alerta.CreateAlert(Alert.AlertType.INFORMATION, "Error", "No archivo db seleccionado", "Debe seleccionar un archivo .db para importar.", st);
        }else{ //si el usuario seleccionó un archivo, se intenta importar
            String name = file.getName();
            //se verifica la extensión del archivo seleccionado, si no es .db, se muestra una alerta informando que no se puede importar el archivo
            if(name.endsWith(".db")){
                IOManager manager = new IOManager();
                manager.importar(file);
            }else{
                Alerta.CreateAlert(Alert.AlertType.INFORMATION, "Error", "No se reconoce este tipo de archivo", "Debe seleccionar un archivo .db para importar.", st);
            }
        }

    }
    //este método permite al usuario seleccionar una ubicación para guardar un archivo de la base de datos
    private void exportar(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(st);

        if(Objects.isNull(file)){
            Alerta.CreateAlert(Alert.AlertType.INFORMATION, "Error", "No ubicacion seleccionada", "Debe seleccionar un archivo .dbca1 para exportar.", st);
        }else{
            String name = file.getName();
            if(name.endsWith(".db")){
                IOManager manager = new IOManager();
                manager.export(file);
            }else{
                Alerta.CreateAlert(Alert.AlertType.INFORMATION, "Error", "No se reconoce este tipo de archivo", "Debe seleccionar un archivo .db para importar.", st);
            }
        }



    }

    private void set_Events(){
        inicio_alumno.setOnAction(event -> mostrarAlumnoInicio());
        registro_alumno.setOnAction(event -> mostrarRegistroAlumno());
        inicio_profesor.setOnAction(event -> mostrarProfesorInicion());
        registro_profesor.setOnAction(event -> mostrarRegistroProfesor());
        inicio_cursos.setOnAction(event -> mostrarInicioCursos());
        inicio_horarios.setOnAction(event -> mostrarInicioHorario());
        inicio_materia.setOnAction(event -> mostrarInicioMateria());
        asistencia_inicio.setOnAction(event -> mostrarAsistencia());
        configuracion.setOnAction(event -> mostrarConfiguracion());
        acerca_de.setOnAction(event -> abrirAcerca_de());
        inicio.setOnAction(event -> abrirInicio());
        importar.setOnAction(event -> importar());
        exportar.setOnAction(event -> exportar());
        tabController = TabManipulator.getInstance(tabmenu, st);
        st.iconifiedProperty().addListener((observable, oldValue, newValue) -> minizedprocedure(newValue));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        set_Events();
        loginprocedure();
    }

    private void loginprocedure(){
        try {
            if (verifyifexistsesions()) {
                disablebuttons(true);
                TabManipulator.getCurrentInstance().blockAllexcept(Fxmls.SYSTEM_LOGIN);
                openLogin();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void minizedprocedure(boolean bool){
        if(bool){
            loginprocedure();
        }
    }

    private boolean verifyifexistsesions(){
        ObservableList<User> users = DaoService.getInstance().getUserInstance().getall().AsObservableList();
        return users.size()>0;
    }

    private boolean openLogin(){
        try {
            LoginController loginController = new LoginController(this);
            TabManipulator.getCurrentInstance().add(Fxmls.SYSTEM_LOGIN, loginController, "Login | System", false);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void disablebuttons(boolean bool){
        for(MenuItem m: loadArraysButtons()){
            m.setDisable(bool);
        }
    }

     public List<MenuItem> loadArraysButtons() {
         List<MenuItem> menus = new ArrayList<>();
         menus.add(inicio_alumno);
         menus.add(registro_alumno);
         menus.add(inicio_profesor);
         menus.add(registro_profesor);
         menus.add(inicio_horarios);
         menus.add(inicio_cursos);
         menus.add(inicio_materia);
         menus.add(asistencia_inicio);
         menus.add(configuracion);
         menus.add(acerca_de);
         menus.add(inicio);
         menus.add(importar);
         menus.add(exportar);
         return menus;
     }

}





