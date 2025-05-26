package model;

public class Idiomas {

	private String[] lblTituloAdministrador = {"ADMINISTRADOR", "ADMINISTRATOR", "ADMINISTRADOR"};
	private String[] lblTituloMenu = {"CONTROLE DE ENTRADA E SAÍDA", "INPUT AND OUTPUT CONTROL", "CONTROL DE ENTRADA Y SALIDA"};
	private String[] lblTituloDAdministrador = {"ADMINISTRADOR", "ADMINISTRATOR", "ADMINISTRADOR"};
	private String[] lblNome = {"NOME", "NAME", "NOMBRE"};
	private String[] lblAreaBusca = {"ÁREA DE BUSCA", "SEARCH AREA", "ÁREA DE BÚSQUEDA"};
	private String[] lblUsuario = {"USUÁRIO", "USER", "USUARIO"};
	private String[] lblNivelPermissao = {"NÍVEL DE PERMISSÃO", "PERMISSION LEVEL", "NIVEL DE PERMISO"};
	private String[] lblAjuda = {"AJUDA", "HELP", "AYUDA"};
	private String[] lblDataHoraEntrada = {"DATA E HORA DE ENTRADA", "DATE AND TIME OF ENTRY", "FECHA Y HORA DE ENTRADA"};
	private String[] lblRG = {"RG", "RG", "RG"};
	private String[] lblApartamento = {"APARTAMENTO", "APARTMENT", "DEPARTAMENTO"};
	private String[] lblSenha = {"SENHA", "PASSWORD", "CONTRASENA"};
	private String[] lblRepetirSenha = {"REPETIR A SENHA", "REPEAT PASSWORD", "REPITA LA CONTRASENA"};
	private String[] lblMotivo = {"MOTIVO", "REASON", "RAZÓN"};
	private String[] btnBaixa = {"BAIXA", "EXIT", "SALIDA"};
	private String[] btnEditar = {"EDITAR", "EDIT", "EDITAR"};
	private String[] btnVoltar = {"VOLTAR", "BACK", "VOLVER"};
	private String[] btnConfirmar = {"CONFIRMAR", "CONFIRM", "CONFIRMAR"};
	private String[] btnCancelar = {"CANCELAR", "CANCEL", "CANCELAR"};
	private String[] btnEntrada = {"ENTRADA", "INPUT", "ENTRADA"};
	private String[] btnEntrar = {"ENTRAR", "ENTER", "ENTRAR"};
	private String[] btnSalvar = {"SALVAR", "SAVE", "AHORRAR"};
	private String[] btnExcluir = {"EXCLUIR", "DELETE", "EXCLUIR"};
	private String[] btnNovo = {"NOVO", "NEW", "NUEVO"};
	private String[] btnLimpar = {"LIMPAR", "CLEAN", "LIMPIAR"};
	private String[] btnInserirImagem = {"INSERIR IMAGEM", "INSERT IMAGE", "INSERTAR IMAGEN"};
	private String[] rdBtnUsuario = {"USUÁRIO", "USER", "USUARIO"};
	private String[] rdBtnAdministrador = {"ADMINISTRADOR", "ADMINISTRATOR", "ADMINISTRADOR"};

	private String[] UsuariosColunasBrasil = {"ID", "USUÁRIO", "PERMISSÃO"};
	private String[] UsuariosColunasEUA = {"ID", "USER", "PERMISSION"};
	private String[] UsuariosColunasEspanha = {"ID", "USUARIO", "PERMISO"};

	private String[] BaixasColunasBrasil = {"ID", "NOME", "APARTAMENTO", "DATA HORA ENTRADA", "TEMPO DE PERMANÊNCIA"};
	private String[] BaixasColunasEUA = {"ID", "NAME", "APARTMENT", "DATE TIME OF ENTRY", "LENGTH OF STAY"};
	private String[] BaixasColunasEspanha = {"ID", "NOMBRE", "DEPARTAMENTO", "FECHA Y HORA DE ENTRADA", "DURACIÓN DE LA ESTANCIA"};
	
	private String[] DaoVisitaNovo = {"Visita incluída com sucesso", "Visit successfully added", "Visita añadida con éxito"};
	private String[] DaoVisitaRetorno = {"Não foi possível localizar a visita selecionado", "Could not find the selected visit", "No se pudo encontrar la visita seleccionada"};
	private String[] DaoVisitaAlterada = {"Visita alterada com sucesso", "Visit successfully updated", "Visita actualizada con éxito"};
	private String[] DaoVisitaExcluir = {"Visita excluída com sucesso", "Visit successfully deleted", "Visita eliminada con éxito"};
	private String[] DaoVisitaVazio = {"Nenhuma visita registrada", "No visits recorded", "No hay visitas registradas"};

	private String[] DaoUsuarioNovo = {"Usuário incluído com sucesso", "User successfully added", "Usuario añadido con éxito"};
	private String[] DaoUsuarioNovoErro = {"Não foi possível criar novo usuário", "Could not create new user", "No se pudo crear un nuevo usuario"};
	private String[] DaoUsuarioValidar = {"Não foi possível validar usuário", "Could not validate user", "No se pudo validar al usuario"};
	private String[] DaoUsuarioRetorno = {"Não foi possível localizar o usuario selecionado", "Could not find the selected user", "No se pudo encontrar el usuario seleccionado"};
	private String[] DaoUsuarioVazio = {"Nenhum usuário registrado", "No users recorded", "No hay usuarios registrados"};
	private String[] DaoUsuarioExcluir = {"Usuário excluído com sucesso", "User successfully deleted", "Usuario eliminado con éxito"};
	private String[] DaoUsuarioAlterado = {"Usuario alterado com sucesso", "User successfully updated", "Usuario actualizado con éxito"};
	private String[] DaoUsuarioAlteradoErro = {"Não foi possível alterar usuário", "Could not update user", "No se pudo actualizar al usuario"};

	private String[] LoginMenssageRS = {"Login realizado com sucesso!", "Login successful!", "¡Inicio de sesión exitoso!"}; 
	private String[] LoginMenssageCampos = {"Verifique as informações!", "Check the information!", "¡Verifique la información!"}; 

	private String[] MenuMenssageErroCAD = {"Erro ao cadastrar visita: ", "Error registering visit: ", "Error al registrar la visita: "}; 
	private String[] MenuMenssageErroLIST = {"Erro ao listar visitas!", "Error listing visits!", "¡Error al listar visitas!"}; 

	private String[] AdmMenssageSUU = {"Selecione um usuário!", "Select a user!", "¡Seleccione un usuario!"}; 

	private String[] BaixasMenssageSUV = {"Selecione uma visita!", "Select a visit!", "¡Seleccione una visita!"}; 
	private String[] BaixasMenssageERRO = {"Erro ao instanciar uma Visita!", "Error instantiating a visit!", "¡Error al instanciar una visita!"};

	private String[] EditarMenssageERRO = {"Erro ao cadastrar visita: ", "Error registering visit: ", "Error al registrar la visita: "}; 
	
	private String[] MonitoramentoAviso1 = {"AVISO: O visitante : ", "NOTICE: The visitor: ", "¡AVISO: El visitante: "};
    private String[] MonitoramentoAviso2 = {" está a mais de 1 hora no prédio! : ", " has been in the building for over 1 hour! : ", " ha estado más de 1 hora en el edificio! : "};
	
	private String[] MenssageCampos= {"Preenche todos os campos!", "Fill in all fields!", "¡Complete todos los campos!"};
	private String[] MenssageSenhaIgual= {"As senhas não são iguais!", "Passwords do not match!", "¡Las contraseñas no coinciden!"}; 
	private String[] MenssageSenha8caracters= {"A senha precisa ter no mínimo 8 caracteres!", "Password must be at least 8 characters long!", "¡La contraseña debe tener al menos 8 caracteres!"};  // #Linha 169 JNovoUsuario

	 private String[] ImagemMenssageConvertida = {"Imagem convertida para binário com sucesso! Tamanho: ", "Image successfully converted to binary! Size: ", "¡Imagen convertida a binario con éxito! Tamaño: "};
	 private String[] ImagemMenssageSemSelecao = {"Nenhuma imagem selecionada", "No image selected", "No se seleccionó ninguna imagen"};
	 private String[] ImagemMenssageRetorno = {"Arquivo de imagem não encontrado: ", "Image file not found: ", "Archivo de imagen no encontrado: "};

	 private String[] ConexaoMenssageErroConectar = {"Erro ao conectar com o banco de dados ", "Error connecting to the database ", "Error al conectar con la base de datos "};
	 private String[] ConexaoMenssageErroFechar = {"Erro ao fechar a conexão ", "Error closing the connection ", "Error al cerrar la conexión "};

	
    public String getLblTituloAdministrador(int idioma) {
        return lblTituloAdministrador[idioma];
    }

    public void setLblTituloAdministrador(int idioma, String valor) {
        lblTituloAdministrador[idioma] = valor;
    }

    public String getLblTituloMenu(int idioma) {
        return lblTituloMenu[idioma];
    }

    public void setLblTituloMenu(int idioma, String valor) {
        lblTituloMenu[idioma] = valor;
    }

    public String getLblTituloDAdministrador(int idioma) {
        return lblTituloDAdministrador[idioma];
    }

    public void setLblTituloDAdministrador(int idioma, String valor) {
        lblTituloDAdministrador[idioma] = valor;
    }

    public String getLblNome(int idioma) {
        return lblNome[idioma];
    }

    public void setLblNome(int idioma, String valor) {
        lblNome[idioma] = valor;
    }

    public String getLblAreaBusca(int idioma) {
        return lblAreaBusca[idioma];
    }

    public void setLblAreaBusca(int idioma, String valor) {
        lblAreaBusca[idioma] = valor;
    }

    public String getLblUsuario(int idioma) {
        return lblUsuario[idioma];
    }

    public void setLblUsuario(int idioma, String valor) {
        lblUsuario[idioma] = valor;
    }

    public String getLblNivelPermissao(int idioma) {
        return lblNivelPermissao[idioma];
    }

    public void setLblNivelPermissao(int idioma, String valor) {
        lblNivelPermissao[idioma] = valor;
    }

    public String getLblAjuda(int idioma) {
        return lblAjuda[idioma];
    }

    public void setLblAjuda(int idioma, String valor) {
        lblAjuda[idioma] = valor;
    }

    public String getLblDataHoraEntrada(int idioma) {
        return lblDataHoraEntrada[idioma];
    }

    public void setLblDataHoraEntrada(int idioma, String valor) {
        lblDataHoraEntrada[idioma] = valor;
    }

    public String getLblRG(int idioma) {
        return lblRG[idioma];
    }

    public void setLblRG(int idioma, String valor) {
        lblRG[idioma] = valor;
    }

    public String getLblApartamento(int idioma) {
        return lblApartamento[idioma];
    }

    public void setLblApartamento(int idioma, String valor) {
        lblApartamento[idioma] = valor;
    }

    public String getLblSenha(int idioma) {
        return lblSenha[idioma];
    }

    public void setLblSenha(int idioma, String valor) {
        lblSenha[idioma] = valor;
    }

    public String getLblRepetirSenha(int idioma) {
        return lblRepetirSenha[idioma];
    }

    public void setLblRepetirSenha(int idioma, String valor) {
        lblRepetirSenha[idioma] = valor;
    }

    public String getLblMotivo(int idioma) {
        return lblMotivo[idioma];
    }

    public void setLblMotivo(int idioma, String valor) {
        lblMotivo[idioma] = valor;
    }

    public String getBtnBaixa(int idioma) {
        return btnBaixa[idioma];
    }

    public void setBtnBaixa(int idioma, String valor) {
        btnBaixa[idioma] = valor;
    }

    public String getBtnEditar(int idioma) {
        return btnEditar[idioma];
    }

    public void setBtnEditar(int idioma, String valor) {
        btnEditar[idioma] = valor;
    }

    public String getBtnVoltar(int idioma) {
        return btnVoltar[idioma];
    }

    public void setBtnVoltar(int idioma, String valor) {
        btnVoltar[idioma] = valor;
    }

    public String getBtnConfirmar(int idioma) {
        return btnConfirmar[idioma];
    }

    public void setBtnConfirmar(int idioma, String valor) {
        btnConfirmar[idioma] = valor;
    }

    public String getBtnCancelar(int idioma) {
        return btnCancelar[idioma];
    }

    public void setBtnCancelar(int idioma, String valor) {
        btnCancelar[idioma] = valor;
    }

    public String getBtnEntrada(int idioma) {
        return btnEntrada[idioma];
    }

    public void setBtnEntrada(int idioma, String valor) {
        btnEntrada[idioma] = valor;
    }

    public String getBtnEntrar(int idioma) {
        return btnEntrar[idioma];
    }

    public void setBtnEntrar(int idioma, String valor) {
        btnEntrar[idioma] = valor;
    }

    public String getBtnSalvar(int idioma) {
        return btnSalvar[idioma];
    }

    public void setBtnSalvar(int idioma, String valor) {
        btnSalvar[idioma] = valor;
    }
    
    public String getBtnExcluir(int idioma) {
        return btnExcluir[idioma];
    }

    public void setBtnExcluir(int idioma, String valor) {
        btnExcluir[idioma] = valor;
    }
    
    public String getBtnNovo(int idioma) {
        return btnNovo[idioma];
    }

    public void setBtnNovo(int idioma, String valor) {
    	btnNovo[idioma] = valor;
    }

    public String getBtnLimpar(int idioma) {
        return btnLimpar[idioma];
    }

    public void setBtnLimpar(int idioma, String valor) {
        btnLimpar[idioma] = valor;
    }
    
    public String getBtnInserirImagem(int idioma) {
        return btnInserirImagem[idioma];
    }

    public void setBtnInserirImagem(int idioma, String valor) {
        btnInserirImagem[idioma] = valor;
    }

    public String getRdBtnUsuario(int idioma) {
        return rdBtnUsuario[idioma];
    }

    public void setRdBtnUsuario(int idioma, String valor) {
        rdBtnUsuario[idioma] = valor;
    }

    public String getRdBtnAdministrador(int idioma) {
        return rdBtnAdministrador[idioma];
    }

    public void setRdBtnAdministrador(int idioma, String valor) {
        rdBtnAdministrador[idioma] = valor;
    }

	public String[] getUsuariosColunasBrasil() {
		return UsuariosColunasBrasil;
	}

	public void setUsuariosColunasBrasil(String[] usuariosColunasBrasil) {
		UsuariosColunasBrasil = usuariosColunasBrasil;
	}

	public String[] getUsuariosColunasEUA() {
		return UsuariosColunasEUA;
	}

	public void setUsuariosColunasEUA(String[] usuariosColunasEUA) {
		UsuariosColunasEUA = usuariosColunasEUA;
	}

	public String[] getUsuariosColunasEspanha() {
		return UsuariosColunasEspanha;
	}

	public void setUsuariosColunasEspanha(String[] usuariosColunasEspanha) {
		UsuariosColunasEspanha = usuariosColunasEspanha;
	}
	
	public String[] getBaixasColunasBrasil() {
		return BaixasColunasBrasil;
	}

	public void setBaixasColunasBrasil(String[] baixasColunasBrasil) {
		BaixasColunasBrasil = baixasColunasBrasil;
	}

	public String[] getBaixasColunasEUA() {
		return BaixasColunasEUA;
	}

	public void setBaixasColunasEUA(String[] baixasColunasEUA) {
		BaixasColunasEUA = baixasColunasEUA;
	}

	public String[] getBaixasColunasEspanha() {
		return BaixasColunasEspanha;
	}

	public void setBaixasColunasEspanha(String[] baixasColunasEspanha) {
		BaixasColunasEspanha = baixasColunasEspanha;
	}
    
	
    public String getDaoVisitaNovo(int idioma) {
        return DaoVisitaNovo[idioma];
    }
    
    public void setDaoVisitaNovo(int idioma, String valor) {
        DaoVisitaNovo[idioma] = valor;
    }
    
    public String getDaoVisitaRetorno(int idioma) {
        return DaoVisitaRetorno[idioma];
    }
    
    public void setDaoVisitaRetorno(int idioma, String valor) {
        DaoVisitaRetorno[idioma] = valor;
    }

    public String getDaoVisitaAlterada(int idioma) {
        return DaoVisitaAlterada[idioma];
    }
    
    public void setDaoVisitaAlterada(int idioma, String valor) {
        DaoVisitaAlterada[idioma] = valor;
    }

    public String getDaoVisitaExcluir(int idioma) {
        return DaoVisitaExcluir[idioma];
    }
    
    public void setDaoVisitaExcluir(int idioma, String valor) {
        DaoVisitaExcluir[idioma] = valor;
    }

    public String getDaoVisitaVazio(int idioma) {
        return DaoVisitaVazio[idioma];
    }
    
    public void setDaoVisitaVazio(int idioma, String valor) {
        DaoVisitaVazio[idioma] = valor;
    }

    public String getDaoUsuarioNovo(int idioma) {
        return DaoUsuarioNovo[idioma];
    }
    
    public void setDaoUsuarioNovo(int idioma, String valor) {
        DaoUsuarioNovo[idioma] = valor;
    }

    public String getDaoUsuarioNovoErro(int idioma) {
        return DaoUsuarioNovoErro[idioma];
    }
    
    public void setDaoUsuarioNovoErro(int idioma, String valor) {
        DaoUsuarioNovoErro[idioma] = valor;
    }

    public String getDaoUsuarioValidar(int idioma) {
        return DaoUsuarioValidar[idioma];
    }
    
    public void setDaoUsuarioValidar(int idioma, String valor) {
        DaoUsuarioValidar[idioma] = valor;
    }

    public String getDaoUsuarioRetorno(int idioma) {
        return DaoUsuarioRetorno[idioma];
    }
    
    public void setDaoUsuarioRetorno(int idioma, String valor) {
        DaoUsuarioRetorno[idioma] = valor;
    }

    public String getDaoUsuarioVazio(int idioma) {
        return DaoUsuarioVazio[idioma];
    }
    
    public void setDaoUsuarioVazio(int idioma, String valor) {
        DaoUsuarioVazio[idioma] = valor;
    }

    public String getDaoUsuarioExcluir(int idioma) {
        return DaoUsuarioExcluir[idioma];
    }
    
    public void setDaoUsuarioExcluir(int idioma, String valor) {
        DaoUsuarioExcluir[idioma] = valor;
    }

    public String getDaoUsuarioAlterado(int idioma) {
        return DaoUsuarioAlterado[idioma];
    }
    
    public void setDaoUsuarioAlterado(int idioma, String valor) {
        DaoUsuarioAlterado[idioma] = valor;
    }

    public String getDaoUsuarioAlteradoErro(int idioma) {
        return DaoUsuarioAlteradoErro[idioma];
    }
    
    public void setDaoUsuarioAlteradoErro(int idioma, String valor) {
        DaoUsuarioAlteradoErro[idioma] = valor;
    }

    public String getLoginMenssageRS(int idioma) {
        return LoginMenssageRS[idioma];
    }
    
    public void setLoginMenssageRS(int idioma, String valor) {
        LoginMenssageRS[idioma] = valor;
    }

    public String getLoginMenssageCampos(int idioma) {
        return LoginMenssageCampos[idioma];
    }
    
    public void setLoginMenssageCampos(int idioma, String valor) {
        LoginMenssageCampos[idioma] = valor;
    }

    public String getMenuMenssageErroCAD(int idioma) {
        return MenuMenssageErroCAD[idioma];
    }
    
    public void setMenuMenssageErroCAD(int idioma, String valor) {
        MenuMenssageErroCAD[idioma] = valor;
    }

    public String getMenuMenssageErroLIST(int idioma) {
        return MenuMenssageErroLIST[idioma];
    }
    
    public void setMenuMenssageErroLIST(int idioma, String valor) {
        MenuMenssageErroLIST[idioma] = valor;
    }

    public String getAdmMenssageSUU(int idioma) {
        return AdmMenssageSUU[idioma];
    }
    
    public void setAdmMenssageSUU(int idioma, String valor) {
        AdmMenssageSUU[idioma] = valor;
    }

    public String getBaixasMenssageSUV(int idioma) {
        return BaixasMenssageSUV[idioma];
    }
    
    public void setBaixasMenssageSUV(int idioma, String valor) {
        BaixasMenssageSUV[idioma] = valor;
    }

    public String getBaixasMenssageERRO(int idioma) {
        return BaixasMenssageERRO[idioma];
    }
    
    public void setBaixasMenssageERRO(int idioma, String valor) {
        BaixasMenssageERRO[idioma] = valor;
    }

    public String getEditarMenssageERRO(int idioma) {
        return EditarMenssageERRO[idioma];
    }
    
    public void setEditarMenssageERRO(int idioma, String valor) {
        EditarMenssageERRO[idioma] = valor;
    }

    public String getMenssageCampos(int idioma) {
        return MenssageCampos[idioma];
    }
    
    public void setMenssageCampos(int idioma, String valor) {
        MenssageCampos[idioma] = valor;
    }

    public String getMenssageSenhaIgual(int idioma) {
        return MenssageSenhaIgual[idioma];
    }
    
    public void setMenssageSenhaIgual(int idioma, String valor) {
        MenssageSenhaIgual[idioma] = valor;
    }

    public String getMenssageSenha8caracters(int idioma) {
        return MenssageSenha8caracters[idioma];
    }
    
    public void setMenssageSenha8caracters(int idioma, String valor) {
        MenssageSenha8caracters[idioma] = valor;
    }
    
    public String getMonitoramentoAviso1(int idioma) {
        return MonitoramentoAviso1[idioma];
    }

    public void setMonitoramentoAviso1(int idioma, String valor) {
        MonitoramentoAviso1[idioma] = valor;
    }

    public String getMonitoramentoAviso2(int idioma) {
        return MonitoramentoAviso2[idioma];
    }

    public void setMonitoramentoAviso2(int idioma, String valor) {
        MonitoramentoAviso2[idioma] = valor;
    }
    
    public String getImagemMenssageConvertida(int idioma) {
        return ImagemMenssageConvertida[idioma];
    }

    public void setImagemMenssageConvertida(int idioma, String valor) {
        ImagemMenssageConvertida[idioma] = valor;
    }

    public String getImagemMenssageSemSelecao(int idioma) {
        return ImagemMenssageSemSelecao[idioma];
    }

    public void setImagemMenssageSemSelecao(int idioma, String valor) {
        ImagemMenssageSemSelecao[idioma] = valor;
    }

    public String getImagemMenssageRetorno(int idioma) {
        return ImagemMenssageRetorno[idioma];
    }

    public void setImagemMenssageRetorno(int idioma, String valor) {
        ImagemMenssageRetorno[idioma] = valor;
    }
    
    public String getConexaoMenssageErroConectar(int idioma) {
        return ConexaoMenssageErroConectar[idioma];
    }

    public void setConexaoMenssageErroConectar(int idioma, String valor) {
        ConexaoMenssageErroConectar[idioma] = valor;
    }

    public String getConexaoMenssageErroFechar(int idioma) {
        return ConexaoMenssageErroFechar[idioma];
    }

    public void setConexaoMenssageErroFechar(int idioma, String valor) {
        ConexaoMenssageErroFechar[idioma] = valor;
    }
	   
    
}
