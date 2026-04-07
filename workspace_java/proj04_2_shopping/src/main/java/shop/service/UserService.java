package shop.service;

import shop.DAO.UserDAO;
import shop.DTO.UserDTO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	// 회원가입
	public boolean join(UserDTO dto) {
		if (dto == null) {
			return false;
		}

		if (dto.getUserId() == null || dto.getUserId().trim().equals("")) {
			return false;
		}

		if (dto.getUserPw() == null || dto.getUserPw().trim().equals("")) {
			return false;
		}

		if (dto.getUserName() == null || dto.getUserName().trim().equals("")) {
			return false;
		}

		if (userDAO.existsByUserId(dto.getUserId())) {
			return false;
		}

		if (dto.getUserRole() == null || dto.getUserRole().trim().equals("")) {
			dto.setUserRole("USER");
		}

		int result = userDAO.insert(dto);
		return result > 0;
	}

	// 로그인
	public UserDTO login(String userId, String userPw) {
		if (userId == null || userId.trim().equals("")) {
			return null;
		}

		if (userPw == null || userPw.trim().equals("")) {
			return null;
		}

		return userDAO.login(userId, userPw);
	}

	// 내 정보 조회
	public UserDTO getUser(int userNo) {
		if (userNo <= 0) {
			return null;
		}

		return userDAO.selectOne(userNo);
	}

	// 내 정보 수정
	public boolean modifyUser(UserDTO dto) {
		if (dto == null) {
			return false;
		}

		if (dto.getUserNo() <= 0) {
			return false;
		}

		if (dto.getUserPw() == null || dto.getUserPw().trim().equals("")) {
			return false;
		}

		if (dto.getUserName() == null || dto.getUserName().trim().equals("")) {
			return false;
		}

		int result = userDAO.update(dto);
		return result > 0;
	}

	// 회원 탈퇴
	public boolean removeUser(int userNo) {
		if (userNo <= 0) {
			return false;
		}

		int result = userDAO.delete(userNo);
		return result > 0;
	}
}