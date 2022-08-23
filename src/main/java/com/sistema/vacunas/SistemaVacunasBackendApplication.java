package com.sistema.vacunas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaVacunasBackendApplication implements CommandLineRunner {


//	@Autowired
//	private RolService rolService;
//
//	@Autowired
//	private TipoVacunaService tipoVacunaService;
//
//	@Autowired
//	private  UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaVacunasBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Usuario usuario=new Usuario();
//		usuario.setCedula("1001");
//		usuario.setNombres("julio");
//		usuario.setApellidos("ramires");
//		usuario.setEmail("jc@hotmail.com");
//		usuario.setClave("12345");


//		Rol rol=new Rol();
//		rol.setId(2L);
//		rol.setNombre("empleada3");
//		rol.setDescripcion("es empleada");
//		usuario.setRol(rol);


//
//
//
//		Rol rolGuardado=rolService.guardarRol(rol);
//		System.out.println("usuario: "+rolGuardado.getNombre());

//		TipoVacunas tipo=new TipoVacunas();
//		tipo.setNombre("Sputnik");
//
//		TipoVacunas tipoGuardado=tipoVacunaService.guardarTipoVacuna(tipo);
//		System.out.println("vacuna: "+tipoGuardado.getNombre());

//	Usuario usuarioGuardado=usuarioService.guardarUsuario(usuario,2L);
//		System.out.println("usuario: "+usuarioGuardado.getCedula());
	}
}
