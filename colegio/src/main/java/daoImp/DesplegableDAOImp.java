package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IDesplegableDAO;
import dto.DesplegableDTO;
import utils.DBUtils;

public class DesplegableDAOImp implements IDesplegableDAO {

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		String sql = "SELECT * FROM municipios ORDER BY nombre";
        ArrayList<DesplegableDTO> listaMunicipios = new ArrayList<>();

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	DesplegableDTO a = new DesplegableDTO(rs.getInt(1), rs.getString(5));
                listaMunicipios.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaMunicipios;
	}

}
