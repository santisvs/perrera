package com.ipartek.formacion.santisvs.perrera.modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.santisvs.perrera.pojo.Perro;

public class PerroDAO implements Persistable<Perro> {

	@Override
	public List<Perro> getAll() throws SQLException {
		// Se abre conexión
		DbConnection conn = new DbConnection();

		// para llamar a un procedimiento creado en heidy
		String sql = "{call getAll (?)}";
		CallableStatement cs = conn.getConnection().prepareCall(sql);
		cs.setInt(1, 500);
		ResultSet res = cs.executeQuery();

		// ArrayList de personas
		ArrayList<Perro> lista = new ArrayList<Perro>();

		// iterar sobre los resultados
		while (res.next()) {
			lista.add(mapeo(res));
		}

		res.close();
		cs.close();
		conn.desconectar();
		return lista;
	}

	@Override
	public Perro getById(int id) throws SQLException {
		// Se abre conexión
		DbConnection conn = new DbConnection();

		// para llamar a un procedimiento creado en heidy
		String sql = "{call getById (?)}";
		CallableStatement cs = conn.getConnection().prepareCall(sql);
		cs.setInt(1, id);
		// ejecutar la consulta
		ResultSet res = cs.executeQuery();

		// iterar sobre los resultados
		res.next();
		Perro p = mapeo(res);

		res.close();
		cs.close();
		conn.desconectar();
		return p;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		DbConnection conn = new DbConnection();
		boolean resul = false;
		String sql = "{call deleteById (?)}";
		CallableStatement cs = conn.getConnection().prepareCall(sql);
		cs.setInt(1, id);
		if (cs.executeUpdate() == 1) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean update(Perro p) throws SQLException {
		boolean resul = false;
		if (p != null) {
			DbConnection conn = new DbConnection();
			String sql = "{call updateReg (?)}";
			CallableStatement cs = conn.getConnection().prepareCall(sql);
			cs.setInt(1, p.getId());
			cs.setString(2, p.getNombre());
			cs.setString(3, p.getRaza());
			cs.setString(4, String.valueOf(p.getSexo()));
			if (cs.executeUpdate() == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public int insert(Perro p) throws SQLException {
		int i = 0;
		// Se abre conexión
		DbConnection conn = new DbConnection();
		try {
			// para llamar a un procedimiento creado en heidy
			String sql = "INSERT INTO `perro` (`nombre`, `raza`, `sexo`) VALUES (?,?,?);";
			PreparedStatement pst = conn.getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getRaza());
			pst.setString(3, String.valueOf(p.getSexo()));

			// ejecutar la consulta
			if (pst.executeUpdate() != 1) {
				throw new SQLException("No se ha insertado el dato");
			}

			ResultSet generatedKeys = pst.getGeneratedKeys();
			generatedKeys.next();
			i = generatedKeys.getInt(1);
			p.setId(i);
			pst.close();
		} catch (Exception e) {
			i = -1;
			e.printStackTrace();
		}
		conn.desconectar();
		return i;
	}

	private Perro mapeo(ResultSet res) throws SQLException {
		Perro p = new Perro();
		p.setId(res.getInt("id"));
		p.setNombre(res.getString("nombre"));
		p.setRaza(res.getString("raza"));
		p.setSexo(res.getString("sexo"));
		return p;
	}

}
