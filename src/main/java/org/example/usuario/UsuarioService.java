package org.example.usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final List<Usuario> usuario=new ArrayList<>();

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void addUsuario(Usuario user) {
        usuario.add(user);
    }
}
