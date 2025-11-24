package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.usuario.Usuario;
import org.example.usuario.UsuarioService;
import org.example.util.JavaFXUtil;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    //Tabla
    @FXML
    private TableView<Usuario> tabla_generica;
    @FXML
    private TableColumn<Usuario, String> correo_col;
    @FXML
    private TableColumn<Usuario, String> plataforma_col;
    @FXML
    private TableColumn<Usuario,Boolean> admin_col;
    @FXML
    private TableColumn<Usuario,String> version_col;
    @FXML
    private TableColumn<Usuario, LocalDate> tiempo_col;
    @FXML
    private Button recargar_button;

    private ObservableList<Usuario> listaUsuarios;
    UsuarioService usuarioService=new UsuarioService();


    //Añadir usuario
    @FXML
    private TextField add_correo;
    @FXML
    private ComboBox<String> add_plataforma;
    @FXML
    private CheckBox add_admin;
    @FXML
    private TextField add_version;
    @FXML
    private Button add_button;
    @FXML
    private Label add_label;



    public void initialize(URL location, ResourceBundle resources) {
        add_plataforma.getItems().addAll("Windows", "Linux", "MacOS");
        setColumnas();
        cargarDatos();
    }

    public void comboButton(ActionEvent event) {
    }


    //Preparar tabla
    //Habilitar tabla
    private void setColumnas(){
        correo_col.setCellValueFactory(new PropertyValueFactory<>("correo"));
        plataforma_col.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        admin_col.setCellValueFactory(new PropertyValueFactory<>("rol"));
        version_col.setCellValueFactory(new PropertyValueFactory<>("version"));
        tiempo_col.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    }

    //Cargar datos
    private void cargarDatos(){
        List<Usuario> list=usuarioService.getUsuario();
        listaUsuarios= FXCollections.observableList(list);
        tabla_generica.setItems(listaUsuarios);
    }


    //Añadir usuario
    public void addUser(ActionEvent event){
        if (add_correo.getText().isEmpty()){
            add_label.setText("Añade el correo");
        }else {
            try{
                usuarioService.addUsuario(new Usuario(
                        0,
                        add_correo.getText(),
                        add_plataforma.getSelectionModel().getSelectedItem(),
                        add_admin.isSelected(),
                        add_version.getText(),
                        LocalDate.now()
                ));
                add_label.setText("Usuario añadido");
                cargarDatos();
            }catch (Exception e){
                add_label.setText("Error");
            }
        }


    }


}
