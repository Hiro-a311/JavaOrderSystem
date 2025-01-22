package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GoodsDTO;
import dto.MemberDTO;
import dto.OrderhistoryDTO;
import dto.SeatDTO;
import dto.TempOrderDTO;
import dto.TempOrderDTO2;


public class DBManager extends Order_systemDAO {

	public List<GoodsDTO> getGoodsList() {

		//SQLに関する変数と初期値
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * " +
	             "FROM order_system.goods " +
	             "WHERE goodsClass = '1' AND goodsFlag = '1';";

		 // DBから得た結果を格納するArrayListを用意
        List<GoodsDTO> goods = new ArrayList<GoodsDTO>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            //SELECTを実行
            rset = pstmt.executeQuery();

            //SELECT文の実行結果をitemに格納
            while (rset.next()) {
                GoodsDTO item = new GoodsDTO();
                item.setGoodsId(rset.getString("goodsId"));
                item.setGoodsName(rset.getString("goodsName"));
                item.setGoodsPrice(rset.getInt("goodsPrice"));
                item.setGoodsClass(rset.getString("goodsClass"));
                item.setGoodsPic(rset.getString("goodsPic"));
                item.setGoodsFlag(rset.getBoolean("goodsFlag"));
                //ArrayListに格納
                goods.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(conn);
        }
        return goods;
    }

	public List<GoodsDTO> getAlcoholList() {

		//SQLに関する変数と初期値
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * " +
	             "FROM order_system.goods " +
	             "WHERE goodsClass = '2' AND goodsFlag = '1';";

		 // DBから得た結果を格納するArrayListを用意
        List<GoodsDTO> alcohols = new ArrayList<GoodsDTO>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            //SELECTを実行
            rset = pstmt.executeQuery();

            //SELECT文の実行結果をitemに格納
            while (rset.next()) {
                GoodsDTO item = new GoodsDTO();
                item.setGoodsId(rset.getString("goodsId"));
                item.setGoodsName(rset.getString("goodsName"));
                item.setGoodsPrice(rset.getInt("goodsPrice"));
                item.setGoodsClass(rset.getString("goodsClass"));
                item.setGoodsPic(rset.getString("goodsPic"));
                item.setGoodsFlag(rset.getBoolean("goodsFlag"));
                //ArralListに格納
                alcohols.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(conn);
        }
        return alcohols;
    }

	public List<GoodsDTO> getSoftdrinkList() {

		//SQLに関する変数と初期値
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * " +
	             "FROM order_system.goods " +
	             "WHERE goodsClass = '3' AND goodsFlag = '1';";

		 // DBから得た結果を格納するArrayListを用意
        List<GoodsDTO> softdrinks = new ArrayList<GoodsDTO>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            //SELECTを実行
            rset = pstmt.executeQuery();

            //SELECT文の実行結果をitemに格納
            while (rset.next()) {
                GoodsDTO item = new GoodsDTO();
                item.setGoodsId(rset.getString("goodsId"));
                item.setGoodsName(rset.getString("goodsName"));
                item.setGoodsPrice(rset.getInt("goodsPrice"));
                item.setGoodsClass(rset.getString("goodsClass"));
                item.setGoodsPic(rset.getString("goodsPic"));
                item.setGoodsFlag(rset.getBoolean("goodsFlag"));
                //ArralListに格納
                softdrinks.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(conn);
        }
        return softdrinks;
    }

	public List<TempOrderDTO> getTempOrderList(){
		//SQLに関する変数と初期値
	    Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM seat, goods WHERE seat.seatId =? AND goods.goodsId= '?'";

		// DBから得た結果を格納するArrayListを用意
        List<TempOrderDTO> tempOrders = new ArrayList<TempOrderDTO>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, seatId);
            pstmt.setString(2, goodsId);

            //SELECTを実行
            rset = pstmt.executeQuery();

            //SELECT文の実行結果をitemに格納
            while (rset.next()) {
                TempOrderDTO item = new TempOrderDTO();
                item.setSeatId(rset.getInt("seatId"));
                item.setGoodsId(rset.getString("goodsId"));
                item.setTempNum(rset.getInt("tempNum"));
                //ArralListに格納
                tempOrders.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(conn);
        }
        return tempOrders ;

        public MemberDTO getLoginUser(String memberMail, String memberPw) {
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT * FROM member WHERE memberMail=? AND memberPw=?";
    		MemberDTO member = null;

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, memberMail);
    			pstmt.setString(2, memberPw);
    			rset = pstmt.executeQuery();

    			if(rset.next()) {
    				member = new MemberDTO();
    				member.setMemberId(rset.getString(1));
    				member.setMemberPw(rset.getString(2));
    				member.setMemberName(rset.getString(3));
    				member.setMemberMail(rset.getString(4));
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}

    		return member;
    	}

    	public boolean setWritingMember(MemberDTO member) {
    		Connection conn = null;
    	    PreparedStatement pstmt = null;
    	    boolean result = false;

    	    try {
    	        conn = getConnection();
    	        System.out.println("Database connection established.");

    	        String sql = "INSERT INTO member VALUES (?,?,?,?)";
    	        pstmt = conn.prepareStatement(sql);

    	        pstmt.setString(1, member.getMemberId());
    	        pstmt.setString(2, member.getMemberPw());
    	        pstmt.setString(3, member.getMemberName());
    	        pstmt.setString(4, member.getMemberMail());

    	        int cnt = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + cnt);

    	        if (cnt == 1) {
    	            result = true;
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            if (pstmt != null) pstmt.close();
    	            if (conn != null) conn.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }

    	    return result;
    	}

    	public boolean checkMemberId(String memberId) {
    		boolean bool = true;

    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT * FROM member WHERE memberId=?";
    		MemberDTO member = null;

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, memberId);
    			rset = pstmt.executeQuery();

    			if(rset.next()) {
    				member = new MemberDTO();
    				member.setMemberId(rset.getString(1));
    				member.setMemberPw(rset.getString(2));
    				member.setMemberName(rset.getString(3));
    				member.setMemberMail(rset.getString(4));
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}

    		System.out.println(member);

    		if(member==null) {
    			bool=false;
    		}

    		return bool;
    	}

    	public boolean setWritingSeat(SeatDTO seat) {
    		Connection conn = null;
    	    PreparedStatement pstmt = null;
    	    boolean result = false;

    	    try {
    	        conn = getConnection();
    	        System.out.println("Database connection established.");

    	        String sql = "UPDATE seat SET memberId = ?, totalNum = ?, alcoholNum = ? WHERE seatId = ?;";
    	        pstmt = conn.prepareStatement(sql);

    	        pstmt.setInt(4, seat.getSeatId());
    	        pstmt.setString(1, seat.getMemberId());
    	        pstmt.setInt(2, seat.getTotalNum());
    	        pstmt.setInt(3, seat.getAlcoholNum());

    	        int cnt = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + cnt);

    	        if (cnt == 1) {
    	            result = true;
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            if (pstmt != null) pstmt.close();
    	            if (conn != null) conn.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }

    	    return result;
    	}

    	public boolean checkGuestId(String memberId) {
    		boolean bool = true;

    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT * FROM seat WHERE memberId=?";
    		SeatDTO seat = null;

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, memberId);
    			rset = pstmt.executeQuery();

    			if(rset.next()) {
    				seat = new SeatDTO();
    				seat.setSeatId(rset.getInt(1));
    				seat.setMemberId(rset.getString(2));
    				seat.setTotalNum(rset.getInt(3));
    				seat.setAlcoholNum(rset.getInt(4));
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}

    		System.out.println(seat);

    		if(seat==null) {
    			bool=false;
    		}

    		return bool;
    	}

    	public boolean deleteSeat(SeatDTO seat) {
    		Connection conn = null;
    	    PreparedStatement pstmt = null;
    	    boolean result = false;

    	    try {
    	        conn = getConnection();
    	        System.out.println("Database connection established.");

    	        String sql = "UPDATE seat SET memberId = '0', totalNum = 0, alcoholNum = 0 WHERE seatId = ?;";
    	        pstmt = conn.prepareStatement(sql);

    	        pstmt.setInt(1, seat.getSeatId());

    	        int cnt = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + cnt);

    	        if (cnt == 1) {
    	            result = true;
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            if (pstmt != null) pstmt.close();
    	            if (conn != null) conn.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	return result;

    	}

    	public SeatDTO checkSeat( int seatId) {
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT * FROM seat WHERE seatID=?";
    		SeatDTO seat = null;

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setInt(1, seatId);
    			rset = pstmt.executeQuery();

    			if(rset.next()) {
    				seat = new SeatDTO();
    				seat.setSeatId(rset.getInt(1));
    				seat.setMemberId(rset.getString(2));
    				seat.setTotalNum(rset.getInt(3));
    				seat.setAlcoholNum(rset.getInt(4));
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}

    		return seat;

    	}

    	public ArrayList<TempOrderDTO> getInfoTemporder(int seatId) {
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT * FROM Temporder WHERE seatId=?";
    		TempOrderDTO temporder = null;
    		ArrayList<TempOrderDTO> templist = new ArrayList<>();

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setInt(1, seatId);
    			//pstmt.setString(2, goodsId);
    			//pstmt.setInt(3, tempNum);
    			rset = pstmt.executeQuery();

    			while(rset.next()) {
    				temporder = new TemporderDTO();
    				temporder.setSeatId(rset.getInt(1));
    				temporder.setGoodsId(rset.getString(2));
    				temporder.setTempNum(rset.getInt(3));
    				templist.add(temporder);
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}

    		return templist;
    	}

    	public String getGoodsName(String goodsId) {
    		String goodsName = "";
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT goodsName FROM goods WHERE goodsId=?";

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, goodsId);
    			rset = pstmt.executeQuery();

    			while(rset.next()) {
    				goodsName = rset.getString("goodsName");
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}
    		return goodsName;
    	}

    	public int getGoodsPrice(String goodsId) {
    		String s = "";
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;
    		int goodsPrice = 0;

    		String sql = "SELECT goodsPrice FROM goods WHERE goodsId=?";

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, goodsId);
    			rset = pstmt.executeQuery();

    			while(rset.next()) {
    				s = rset.getString("goodsPrice");
    				goodsPrice = Integer.parseInt(s);
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}
    		return goodsPrice;
    	}

    	public boolean setWritingOrderHistory(OrderhistoryDTO history) {
    		Connection conn = null;
    	    PreparedStatement pstmt = null;
    	    boolean result = false;

    	    try {
    	        conn = getConnection();
    	        System.out.println("Database connection established.");

    	        String sql = "INSERT INTO orderhistory VALUES (?,?,?,?)";
    	        pstmt = conn.prepareStatement(sql);

    	        pstmt.setInt(1, history.getSeatId());
    	        pstmt.setString(2, history.getGoodsId());
    	        pstmt.setInt(3, history.getOrderNum());
    	        pstmt.setInt(4, history.getOrderFlag());

    	        int cnt = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + cnt);

    	        if (cnt == 1) {
    	            result = true;
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            if (pstmt != null) pstmt.close();
    	            if (conn != null) conn.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }

    	    return result;
    	}

    	public String getGoodsId(String goodsName) {
    		String goodsId = "";
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rset = null;

    		String sql = "SELECT goodsId FROM goods WHERE goodsName=?";

    		try {
    			conn = getConnection();

    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, goodsName);
    			rset = pstmt.executeQuery();

    			while(rset.next()) {
    				goodsId = rset.getString("goodsId");
    			}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} finally {
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}
    		return goodsId;
    	}

    	public boolean deleteTemp(int seatId) {
    		Connection conn = null;
    	    PreparedStatement pstmt = null;
    	    boolean result = false;

    	    try {
    	        conn = getConnection();
    	        System.out.println("Database connection established.");

    	        String sql = "DELETE FROM order_system.temporder WHERE seatId = ?;";
    	        pstmt = conn.prepareStatement(sql);

    	        pstmt.setInt(1, seatId);

    	        int cnt = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + cnt);

    	        if (cnt == 1) {
    	            result = true;
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        try {
    	            if (pstmt != null) pstmt.close();
    	            if (conn != null) conn.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	return result;
    	}
	}
}

