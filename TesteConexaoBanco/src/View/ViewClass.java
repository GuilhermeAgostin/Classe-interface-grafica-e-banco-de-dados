package View;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.Position;

import Conexao.ConnectionClass;
import Model.Endereco;
import Model.Perfil;
import Model.Usuario;
import Table.Tabela_Endereco;
import Table.Tabela_Perfil;
import Table.Tabela_Usuario;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.swing.JOptionPane;

public class ViewClass<Connection, Conexao> extends Application

{

    public ListView<Integer> list = new ListView<Integer>();
    public ListView<String> listUsuario = new ListView<String>();
    public ListView<String> listEndereco = new ListView<String>();


    @Override
    public void start(Stage primaryStage) throws Exception {

        /********************** PERFIL **********************************/

        Label TituloPerfil = new Label();
        TituloPerfil.setText("Painel Administrador");
        TituloPerfil.setLayoutX(280);
        TituloPerfil.setLayoutY(20);
        TituloPerfil.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        // ______________________________________________________________________________________________________________

        Label TabelaPerfil = new Label();
        TabelaPerfil.setText("Perfil");
        TabelaPerfil.setLayoutX(95);
        TabelaPerfil.setLayoutY(99);
        TabelaPerfil.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        // ______________________________________________________________________________________________________________

        TextField InputNomePerfil = new TextField();

        InputNomePerfil.setPromptText("Digite o nome do perfil");
        InputNomePerfil.setAlignment(Pos.CENTER);
        InputNomePerfil.setLayoutX(26);
        InputNomePerfil.setLayoutY(132);
        InputNomePerfil.setPrefWidth(173);
        InputNomePerfil.setPrefHeight(24);
        InputNomePerfil.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        Button btn = new Button();
        // Font font =
        btn.setText("Cadastrar");
        btn.setFont(Font.font("Century Gothic", 15));
        btn.setLayoutX(72);
        btn.setLayoutY(270);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String NomeNovoPerfil = InputNomePerfil.getText();

                Perfil perf = new Perfil();
                perf.setNome(NomeNovoPerfil);

                Tabela_Perfil tb_perf = new Tabela_Perfil();

                try {
                    tb_perf.insereRegistro(perf);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Tabela_Perfil tbperf = new Tabela_Perfil();
                //tbperf.getListaIds();
                 
                List<Perfil> lp;
                try {
                    list.getItems().clear();

                    lp = tbperf.getListaIds();
                    for(Perfil perfil : lp)
                    {
                        list.getItems().addAll(perfil.getIdPerfil());
                       // ilp.add(perfil.getIdPerfil());
                    }

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
                
               

            }
        });

        // ______________________________________________________________________________________________________________


        Label ListaPerfis = new Label();
        ListaPerfis.setText("Lista de perfis");
        ListaPerfis.setLayoutX(72);
        ListaPerfis.setLayoutY(310);
        ListaPerfis.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        list.setLayoutX(45);
        list.setLayoutY(340);
        list.setPrefWidth(150);
        list.setPrefHeight(120);

        Tabela_Perfil tbperf = new Tabela_Perfil();
        //tbperf.getListaIds();
         
        list.getItems().clear();

        List<Perfil> lp =  tbperf.getListaIds();
        
        for(Perfil perfil : lp)
        {
            list.getItems().addAll(perfil.getIdPerfil());
           // ilp.add(perfil.getIdPerfil());
        }
        
        RenderizacaoItemListaSelecionadoPerfil();
       
        // _______________________________________________________________________________________________________________

        /********************** USUARIO **********************************/

        Label TabelaUsuario = new Label();
        TabelaUsuario.setText("Usuario");
        TabelaUsuario.setLayoutX(338);
        TabelaUsuario.setLayoutY(99);
        TabelaUsuario.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        // ______________________________________________________________________________________________________________

        TextField InputNomeUsuario = new TextField();
        InputNomeUsuario.setPromptText("Digite o nome do usuário");
        InputNomeUsuario.setAlignment(Pos.CENTER);
        InputNomeUsuario.setLayoutX(269);
        InputNomeUsuario.setLayoutY(132);
        InputNomeUsuario.setPrefWidth(173);
        InputNomeUsuario.setPrefHeight(24);
        InputNomeUsuario.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputIdPerfilUsuario = new TextField();
        InputIdPerfilUsuario.setPromptText("Digite o id do perfil");
        InputIdPerfilUsuario.setAlignment(Pos.CENTER);
        InputIdPerfilUsuario.setLayoutX(269);
        InputIdPerfilUsuario.setLayoutY(166);
        InputIdPerfilUsuario.setPrefWidth(173);
        InputIdPerfilUsuario.setPrefHeight(24);
        InputIdPerfilUsuario.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputCPFUsuario = new TextField();
        InputCPFUsuario.setPromptText("Digite o CPF");
        InputCPFUsuario.setAlignment(Pos.CENTER);
        InputCPFUsuario.setLayoutX(269);
        InputCPFUsuario.setLayoutY(200);
        InputCPFUsuario.setPrefWidth(173);
        InputCPFUsuario.setPrefHeight(24);
        InputCPFUsuario.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputSexoUsuario = new TextField();
        InputSexoUsuario.setPromptText("Digite o sexo");
        InputSexoUsuario.setAlignment(Pos.CENTER);
        InputSexoUsuario.setLayoutX(269);
        InputSexoUsuario.setLayoutY(234);
        InputSexoUsuario.setPrefWidth(173);
        InputSexoUsuario.setPrefHeight(24);
        InputSexoUsuario.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________


        Label ListaUsuarios = new Label();
        ListaUsuarios.setText("Lista de usuários");
        ListaUsuarios.setLayoutX(300);
        ListaUsuarios.setLayoutY(310);
        ListaUsuarios.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        listUsuario.setLayoutX(285);
        listUsuario.setLayoutY(340);
        listUsuario.setPrefWidth(150);
        listUsuario.setPrefHeight(120);

        Tabela_Usuario tb_usu = new Tabela_Usuario();

        List<Usuario> lusu =  tb_usu.getListaUsuarios();
        
        for(Usuario usuario : lusu)
        {
            listUsuario.getItems().addAll(usuario.getNome());
           // ilp.add(perfil.getIdPerfil());
        }


        RenderizacaoItemListaSelecionadoUsuario();

       // ______________________________________________________________________________________________________________

        Button btnUsuario = new Button();
        // Font font =
        btnUsuario.setText("Cadastrar");
        btnUsuario.setFont(Font.font("Century Gothic", 15));
        btnUsuario.setLayoutX(315);
        btnUsuario.setLayoutY(270);
        btnUsuario.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                

                String NomeNovoUsuario = InputNomeUsuario.getText(); //getText();
                int IdPerfilNovoUsuario = Integer.parseInt(InputIdPerfilUsuario.getText()); 
                String CPFNovoUsuario = InputCPFUsuario.getText();
                String Sexo = InputSexoUsuario.getText();

                Usuario usuario = new Usuario();
                usuario.setNome(NomeNovoUsuario);
                usuario.setIdPerfil(IdPerfilNovoUsuario);
                usuario.setCPF(CPFNovoUsuario);
                usuario.setSexo(Sexo);

                Tabela_Usuario tb_usu = new Tabela_Usuario();

                try {
                    tb_usu.insereRegistro(usuario);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //tbperf.getListaIds();
                 
                listUsuario.getItems().clear();
                List<Usuario> lu;
                try {
                    lu = tb_usu.getListaUsuarios();
                    for(Usuario usuar : lu)
                    {
                        listUsuario.getItems().addAll(usuar.getNome());
                       // ilp.add(perfil.getIdPerfil());
                    }

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        

       


        // para cadastrar um novo perfil ou um novo usuario que seja, fazer o seguinte:

        /*
         * Criar uma TextBox que tenha um texto do tipo PromptText com o nome de:
         * "Click para inserir dados de um novo Usuario" por exemplo, sendo assim abri r
         * um JPanel para que eu consiga pegar todos os dados que preciso sem ter que
         * poluir a aplicação com varias caixas de text e parecer um formulário;
         *
         */

        // _______________________________________________________________________________________________________________

        /********************** ENDERECO **********************************/

        Label TabelaEndereco = new Label();
        TabelaEndereco.setText("Endereço");
        TabelaEndereco.setLayoutX(550);
        TabelaEndereco.setLayoutY(99);
        TabelaEndereco.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        // ______________________________________________________________________________________________________________

        TextField InputNomeBairro = new TextField();
        InputNomeBairro.setPromptText("Digite o bairro");
        InputNomeBairro.setAlignment(Pos.CENTER);
        InputNomeBairro.setLayoutX(500);
        InputNomeBairro.setLayoutY(132);
        InputNomeBairro.setPrefWidth(180);
        InputNomeBairro.setPrefHeight(24);
        InputNomeBairro.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputNumeroEndereco = new TextField();
        InputNumeroEndereco.setPromptText("Digite o numero do endereço");
        InputNumeroEndereco.setAlignment(Pos.CENTER);
        InputNumeroEndereco.setLayoutX(500);
        InputNumeroEndereco.setLayoutY(166);
        InputNumeroEndereco.setPrefWidth(173);
        InputNumeroEndereco.setPrefHeight(24);
        InputNumeroEndereco.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputMunicipio = new TextField();
        InputMunicipio.setPromptText("Digite a municipio");
        InputMunicipio.setAlignment(Pos.CENTER);
        InputMunicipio.setLayoutX(500);
        InputMunicipio.setLayoutY(200);
        InputMunicipio.setPrefWidth(173);
        InputMunicipio.setPrefHeight(24);
        InputMunicipio.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________

        TextField InputCEP = new TextField();
        InputCEP.setPromptText("Digite o CEP");
        InputCEP.setAlignment(Pos.CENTER);
        InputCEP.setLayoutX(500);
        InputCEP.setLayoutY(234);
        InputCEP.setPrefWidth(173);
        InputCEP.setPrefHeight(24);
        InputCEP.setFont(Font.font("Century Gothic", 12));

        // ______________________________________________________________________________________________________________


        Label ListaEndereco = new Label();
        ListaEndereco.setText("Lista de endereços");
        ListaEndereco.setLayoutX(520);
        ListaEndereco.setLayoutY(310);
        ListaEndereco.setFont(Font.font("Century Gothic", FontWeight.BOLD, 15));

        listEndereco.setLayoutX(512);
        listEndereco.setLayoutY(340);
        listEndereco.setPrefWidth(150);
        listEndereco.setPrefHeight(120);

        Tabela_Endereco tb_ende = new Tabela_Endereco();

        List<Endereco> lende =  tb_ende.getListaNomeEndereco();
        
        listEndereco.getItems().clear();

        for(Endereco endereco : lende)
        {
            listEndereco.getItems().addAll(endereco.getBairro());
           // ilp.add(perfil.getIdPerfil());
        }

        RenderizacaoItemListaSelecionadoEndereco();

       // ______________________________________________________________________________________________________________


        Button btnEndereco = new Button();
        // Font font =
        btnEndereco.setText("Cadastrar");
        btnEndereco.setFont(Font.font("Century Gothic", 15));
        btnEndereco.setLayoutX(542);
        btnEndereco.setLayoutY(270);
        btnEndereco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String NomeNovoEndereco = InputNomeBairro.getText(); //getText();
                int NumeroNovoEndereco = Integer.parseInt(InputNumeroEndereco.getText()); 
                String MunicipioNovoEndereco = InputMunicipio.getText();
                String CEPNovoEndereco = InputCEP.getText();

                Endereco endereco = new Endereco();
                endereco.setBairro(NomeNovoEndereco);
                endereco.setNumero(NumeroNovoEndereco);
                endereco.setMunicipio(MunicipioNovoEndereco);
                endereco.setCEP(CEPNovoEndereco);

                Tabela_Endereco tb_enderecos = new Tabela_Endereco();

                try {
                    tb_enderecos.insereRegistro(endereco);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //tbperf.getListaIds();
                 
                listEndereco.getItems().clear();
                List<Endereco> le;
                try {
                    le = tb_enderecos.getListaNomeEndereco();
                    for(Endereco endereco3 : le)
                    {
                        listEndereco.getItems().addAll(endereco3.getBairro());
                       // ilp.add(perfil.getIdPerfil());
                    }

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            
        });

        // ______________________________________________________________________________________________________________ 

        Pane root = new Pane();
        root.getChildren().addAll(TabelaPerfil, InputNomePerfil, TituloPerfil, list, ListaPerfis, btn, TabelaUsuario,
                InputNomeUsuario,InputIdPerfilUsuario,InputCPFUsuario, InputSexoUsuario, ListaUsuarios, listUsuario,btnUsuario, 
                TabelaEndereco, InputNomeBairro, InputNumeroEndereco,InputMunicipio, InputCEP, ListaEndereco,listEndereco,btnEndereco);

        Scene scene = new Scene(root, 710, 516);

        primaryStage.setTitle("Administração");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ______________________________________________________________________________________________________________

    public void RenderizacaoItemListaSelecionadoPerfil() 
    
    {
        list.setOnMouseClicked(event -> {
            String selectedItem = list.getSelectionModel().getSelectedItem().toString();

            Tabela_Perfil perfil1 = new Tabela_Perfil();

            Alert d = new Alert(AlertType.CONFIRMATION, selectedItem);
            d.setTitle("Escolha uma opção para ser realizada");

            try {
                d.setHeaderText("Perfil: " + perfil1.getNomePerfil(selectedItem));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            d.setContentText("");
            //NomePerfilTxt.setText();

            
            ButtonType botaoEditar = new ButtonType("Editar");
            ButtonType botaoExcluir = new ButtonType("Excluir");
            ButtonType botaoVoltar = new ButtonType("Voltar", ButtonData.CANCEL_CLOSE);

            d.getButtonTypes().setAll(botaoEditar, botaoExcluir, botaoVoltar);

            Optional<ButtonType> result = d.showAndWait();

            if (result.get() == botaoEditar) 
            {
                TextInputDialog dialog2 = new TextInputDialog();
                dialog2.setTitle("Edição Perfil");
                dialog2.setHeaderText("");
                dialog2.setContentText("Insira o novo nome do perfil:");

                // Traditional way to get the response value.
                Optional<String> result2 = dialog2.showAndWait();
                if (result2.isPresent()){

                    Perfil perf = new Perfil();
                    perf.setNome(result2.get());
                    perf.setIdPerfil(Integer.parseInt(selectedItem));
    
                    Tabela_Perfil tb_perf = new Tabela_Perfil();
    
                    try {
                        tb_perf.alterarRegistro(perf);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    System.out.println("Your name: " + result2.get());
                }
                

               
               
            }
            else if (result.get() == botaoExcluir) {

                    
    
                    Tabela_Perfil tb_perf = new Tabela_Perfil();
                    Perfil perfilParaExcluir = new Perfil();
    
                    try {
                        tb_perf.deletaRegistro(perfilParaExcluir, selectedItem);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    list.getItems().clear();
                    Tabela_Perfil tbperf = new Tabela_Perfil();
                    //tbperf.getListaIds();
                    
                    List<Perfil> lp;
                    try {
                        
                        lp = tbperf.getListaIds();

                        for(Perfil perfil : lp)
                        {
                            list.getItems().addAll(perfil.getIdPerfil());
                        // ilp.add(perfil.getIdPerfil());
                        }

                    } 
                    catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    

                // ... user chose "Two"
            } else if (result.get() == botaoVoltar) {

                // ... user chose "Three"
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        });
    }


    //______________________________________________________________________________________________________________________

    public void RenderizacaoItemListaSelecionadoUsuario() throws SQLException 
    
    {
        listUsuario.setOnMouseClicked(event -> {
           
            String selectedItem = listUsuario.getSelectionModel().getSelectedItem().toString();

            Tabela_Usuario usuario1 = new Tabela_Usuario();

            Alert d = new Alert(AlertType.CONFIRMATION, selectedItem);
            d.setTitle("Escolha uma opção para ser realizada");

            d.setHeaderText("Usuario: " + selectedItem);
            d.setContentText("");
            //NomePerfilTxt.setText();

            
            ButtonType botaoEditar = new ButtonType("Editar");
            ButtonType botaoExcluir = new ButtonType("Excluir");
            ButtonType botaoVoltar = new ButtonType("Voltar", ButtonData.CANCEL_CLOSE);

            d.getButtonTypes().setAll(botaoEditar, botaoExcluir, botaoVoltar);

            Optional<ButtonType> result = d.showAndWait();

            if (result.get() == botaoEditar) 
            {
                TextInputDialog dialog2 = new TextInputDialog();
                dialog2.setTitle("Edição Usuário");
                dialog2.setHeaderText("");
                dialog2.setContentText("Insira o novo nome do usuário:");

                // Traditional way to get the response value.
                Optional<String> result2 = dialog2.showAndWait();
                if (result2.isPresent()){

                    Usuario usuario3 = new Usuario();
                    usuario3.setNome(result2.get());
                    //usuario3.setIdPerfil(Integer.parseInt(selectedItem));
    
                    Tabela_Usuario tb_usu3 = new Tabela_Usuario();
    
                    try {
                        tb_usu3.alterarRegistro(usuario3, selectedItem);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    listUsuario.getItems().clear();

                    Tabela_Usuario tbUsuario = new Tabela_Usuario();
                    //tbperf.getListaIds();
                    
                    List<Usuario> lusu;
                    try {
                        
                        lusu = tbUsuario.getListaUsuarios();

                        for(Usuario usuario4 : lusu)
                        {
                            listUsuario.getItems().addAll(usuario4.getNome());
                        // ilp.add(perfil.getIdPerfil());
                        }

                    } 
                    catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    System.out.println("Your name: " + result2.get());
                }
            }

            else if (result.get() == botaoExcluir) {

    
                    Tabela_Usuario tb_usuario = new Tabela_Usuario();
                    Usuario UsuarioParaExcluir = new Usuario();
    
                    try {
                        tb_usuario.deletaRegistro(UsuarioParaExcluir, selectedItem);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    listUsuario.getItems().clear();

                    Tabela_Usuario tbusu = new Tabela_Usuario();
                    //tbperf.getListaIds();
                    
                    List<Usuario> lusu;
                    try {
                        
                        lusu = tbusu.getListaUsuarios();

                        for(Usuario usuario4 : lusu)
                        {
                            listUsuario.getItems().addAll(usuario4.getNome());
                        // ilp.add(perfil.getIdPerfil());
                        }

                    } 
                    catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    

                    
                   


                
                // ... user chose "Two"
            } else if (result.get() == botaoVoltar) {

                // ... user chose "Three"
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        });
    }

    // ______________________________________________________________________________________________________________

    
    public void RenderizacaoItemListaSelecionadoEndereco() throws SQLException 
    
    {
        listEndereco.setOnMouseClicked(event -> {
            String selectedItem = listEndereco.getSelectionModel().getSelectedItem().toString();

            Tabela_Endereco endereco1 = new Tabela_Endereco();

            Alert d = new Alert(AlertType.CONFIRMATION, selectedItem);
            d.setTitle("Escolha uma opção para ser realizada");

            d.setHeaderText("Endereço: " + selectedItem);
            d.setContentText("");
            //NomePerfilTxt.setText();

            
            ButtonType botaoEditar = new ButtonType("Editar");
            ButtonType botaoExcluir = new ButtonType("Excluir");
            ButtonType botaoVoltar = new ButtonType("Voltar", ButtonData.CANCEL_CLOSE);

            d.getButtonTypes().setAll(botaoEditar, botaoExcluir, botaoVoltar);

            Optional<ButtonType> result = d.showAndWait();

            if (result.get() == botaoEditar) 
            {
                TextInputDialog dialog2 = new TextInputDialog();
                dialog2.setTitle("Edição Endereço");
                dialog2.setHeaderText("");
                dialog2.setContentText("Insira o novo nome do bairro:");

                // Traditional way to get the response value.
                Optional<String> result2 = dialog2.showAndWait();
                if (result2.isPresent()){

                    Endereco ende = new Endereco();
                    ende.setBairro(result2.get());
    
                    Tabela_Endereco tb_ende = new Tabela_Endereco();
    
                    try {
                        tb_ende.alterarRegistro(ende, selectedItem);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    listEndereco.getItems().clear();

                    Tabela_Endereco tbendereco = new Tabela_Endereco();
                    //tbperf.getListaIds();
                    
                    List<Endereco> lende;
                    try {
                        
                        lende = tbendereco.getListaNomeEndereco();

                        for(Endereco endereco4 : lende)
                        {
                            listEndereco.getItems().addAll(endereco4.getBairro());
                        // ilp.add(perfil.getIdPerfil());
                        }

                    } 
                    catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    System.out.println("Your name: " + result2.get());
                }
               
            }
            else if (result.get() == botaoExcluir) {

                    Tabela_Endereco tb_ende = new Tabela_Endereco();
                    Endereco enderecoParaExcluir = new Endereco();
    
                    try {
                        tb_ende.deletaRegistro(enderecoParaExcluir, selectedItem);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    listEndereco.getItems().clear();
                    Tabela_Endereco tbendereco = new Tabela_Endereco();
                    //tbperf.getListaIds();
                    
                    List<Endereco> le;
                    try {
                        
                        le = tbendereco.getListaNomeEndereco();

                        for(Endereco endereco2 : le)
                        {
                            listEndereco.getItems().addAll(endereco2.getBairro());
                        // ilp.add(perfil.getIdPerfil());
                        }

                    } 
                    catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    

                    
                   


                
                // ... user chose "Two"
            } else if (result.get() == botaoVoltar) {

                // ... user chose "Three"
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        });
    }
    

}
