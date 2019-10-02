package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;

import entity.UsuarioDTO;
import modelo.ModeloUsuarioDTO;

@ManagedBean(name="usuarioDTOController")
@ViewScoped
public class UsuarioDTOController {

	private UsuarioDTO usuarioDTO;
	private List<UsuarioDTO>listadoUsuarioDTO;
	private UIData dtFila;
	
	@PostConstruct
	public void init(){
		usuarioDTO=new UsuarioDTO();
		cargarTable();
	}
	public void cargarTable(){
		listadoUsuarioDTO=new ModeloUsuarioDTO().listarUsuarioDTO();
	}
	public void seleccionar(){
		usuarioDTO=(UsuarioDTO)dtFila.getRowData();
	}
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public List<UsuarioDTO> getListadoUsuarioDTO() {
		return listadoUsuarioDTO;
	}
	public void setListadoUsuarioDTO(List<UsuarioDTO> listadoUsuarioDTO) {
		this.listadoUsuarioDTO = listadoUsuarioDTO;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	public void registrarUsuario() {
		usuarioDTO.getCod_usu();
		new ModeloUsuarioDTO().insertarUsuarioDTO(usuarioDTO);
		cargarTable();
	}
	
	public void actualizarUsuario() {
		usuarioDTO.getCod_usu();
		new ModeloUsuarioDTO().actualizarUsuarioDTO(usuarioDTO);
		cargarTable();
	}
	
	public void eliminarUsuario() {
		new ModeloUsuarioDTO().eliminarUsuarioDTO(usuarioDTO.getCod_usu());
		cargarTable();
	}
	
	
	
}
