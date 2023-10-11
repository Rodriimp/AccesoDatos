package proyecto.services;

import java.sql.Connection;
import java.sql.SQLException;

import proyecto.dao.UsuariosDao;
import proyecto.modelo.Usuario;

public class UsuariosService {
	private OpenConnection connProvider;

	public UsuariosService() {
		this.connProvider = new OpenConnection();
	}

	public Usuario login(String email, String pass) throws FctException, AutenticarException {
		Connection conn = null;
		Usuario u = new Usuario();
		try {
			conn = connProvider.abrirConexion();
			UsuariosDao userDao = new UsuariosDao();
			u = userDao.consultarUsuario(conn, email);

			if (u == null) {
				throw new AutenticarException("El email no es válido");
			}
			if (!u.getPassword().equals(pass)) {
				throw new AutenticarException("La contraseña no es válida");

			} else {
				return u;
			}

		} catch (SQLException e) {
			throw new FctException("Error al obtener datos del usuario de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void altaUsuario(Usuario usuario) throws FctException {
		Connection conn = null;

		try {
			conn = connProvider.abrirConexion();
			UsuariosDao userDao = new UsuariosDao();
			Usuario u = userDao.consultarUsuario(conn, usuario.getEmail());

			if (u == null) {
				userDao.insertarUsuario(conn, usuario);
			} else {
				throw new FctException("El usuario ya existe");
			}

		} catch (SQLException e) {
			throw new FctException("Error al obtener datos del usuario de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
