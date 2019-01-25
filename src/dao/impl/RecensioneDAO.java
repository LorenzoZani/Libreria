package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import dao.IRecensioneDAO;
import models.Recensione;

public class RecensioneDAO extends AbstractDAO implements IRecensioneDAO {

	private static final String LIST_QUERY = "SELECT * FROM recensione";
	private static final String CREATE_QUERY = "INSERT INTO recensione (valutazione, testo, libro_id) VALUES (?,?,?)";
	private static final String READ_QUERY = "SELECT * FROM recensione WHERE id = ? ";
	private static final String UPDATE_QUERY = "UPDATE recensione SET valutazione=? , testo=? , libro_id=? WHERE id = ?";
	private static final String DELETE_QUERY = "DELETE FROM recensione WHERE id = ?";

	@Override
	public List<Recensione> getAllRecensione() {

		List<Recensione> result = new ArrayList<>();
		try (Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(LIST_QUERY);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Recensione r = new Recensione(rs.getInt("valutazione"), rs.getString("testo"), rs.getInt("libro_id"));
				r.setId(rs.getInt("id"));
				result.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Recensione getRecensione(int id) {
		Recensione recensione = null;
		ResultSet rs = null;
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(READ_QUERY);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next() && rs != null) {
				recensione = new Recensione(rs.getInt("valutazione"), rs.getString("testo"), rs.getInt("libro_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (Exception rse) {
			rse.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception rse) {
				rse.printStackTrace();
			}
		}
		return recensione;
	}

	@Override
	public void createRecensione(Recensione recensione) {

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_QUERY);) {
			ps.setInt(1, recensione.getValutazione());
			ps.setString(2, recensione.getTesto());
			ps.setInt(3, recensione.getLibro_id());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRecensione(Recensione recensione) {

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_QUERY);) {

			ps.setInt(1, recensione.getValutazione());
			ps.setString(2, recensione.getTesto());
			ps.setInt(3, recensione.getLibro_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRecensione(int id) {

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_QUERY);) {
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
