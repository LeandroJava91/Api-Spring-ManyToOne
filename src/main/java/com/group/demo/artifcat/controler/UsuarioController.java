package com.group.demo.artifcat.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.demo.artifcat.models.Transporte;
import com.group.demo.artifcat.models.Usuario;
import com.group.demo.artifcat.models.UsuarioDto;
import com.group.demo.artifcat.repository.TransporteRepository;
import com.group.demo.artifcat.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private TransporteRepository trans;
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> obtenerUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        List<UsuarioDto> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            String nombreMedio = usuario.getTransporte() != null ? usuario.getTransporte().getNombreMedio() : null;
            UsuarioDto usuarioDTO = new UsuarioDto(usuario.getNombre(), usuario.getApellido(), nombreMedio);
            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;
    }
    
    @PostMapping("/savetrans")
	public Transporte save(@RequestBody Transporte transporte) {
    	trans.save(transporte);
		return trans.save(transporte);
	}
    


@PostMapping("/saveusu")
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

/////////////////////////////editar////////



    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            
            // Actualizar la relación con Transporte
            Optional<Transporte> optionalTransporte = trans.findById(usuarioActualizado.getTransporte().getIdUsuario());
            if (optionalTransporte.isPresent()) {
                Transporte transporteExistente = optionalTransporte.get();
                usuarioExistente.setTransporte(transporteExistente);
            }
            Usuario usuarioActualizadoDb = usuarioRepository.save(usuarioExistente);
            return ResponseEntity.ok(usuarioActualizadoDb);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
 
