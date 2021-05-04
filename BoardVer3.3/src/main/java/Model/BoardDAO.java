package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;

public class BoardDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<BoardVO> selBoardList() {

		List<BoardVO> list = new ArrayList<BoardVO>();

		String sql = "SELECT * FROM lin_table ORDER BY iboard DESC";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				Date regidate = rs.getDate("regidate");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegidate(regidate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}

	public BoardVO selBoard(int iboard) {
		String sql = "SELECT * FROM lin_table WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();

				iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				Date regidate = rs.getDate("regidate");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegidate(regidate);

				return vo;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;// ??
	}

	public int insertBoard(BoardVO vo) {
		String sql = "INSERT INTO lin_table (title, ctnt) VALUES (?,?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate(); // 영향받은 행의 갯수가 return됨 (int)
			// insert, update, delete 일반적으로 1행만 영향을 받는다.
			// select만 ps.executeQuery(); 사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0; // int형이라 return 값이 숫자이다.
	}

	public int updateBoard(BoardVO param) {
		String sql = "UPDATE lin_table SET title = ?, ctnt = ? WHERE iboard =?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}

	public int delBoard(BoardVO param) {
		String sql = "DELETE FROM lin_table WHERE iboard =?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, param.getIboard());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}

}
