package miniproject.borad.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.controller.Controller;
import miniproject.vo.AnimalVO;

public class LostPetSearchController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=Aijc7heSY0CpUFjf8ExZRtZXuIEXnuZnCKxAAcJu4al4y5R7OCAxhsI026SfK%2FIT9XfMRRADcxJnQKlKngDWyQ%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8")
				+ "=20180401");
		urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8")
		+ "=20180501");
		/*
		 * urlBuilder.append("&" + URLEncoder.encode("bgnde","UTF-8") + "=" +
		 * URLEncoder.encode("20140601", "UTF-8")); 유기날짜 (검색 시작일) (YYYYMMDD)
		 * urlBuilder.append("&" + URLEncoder.encode("endde","UTF-8") + "=" +
		 * URLEncoder.encode("20140630", "UTF-8")); 유기날짜 (검색 종료일) (YYYYMMDD)
		 * urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" +
		 * URLEncoder.encode("417000", "UTF-8")); 축종코드 - 개 : 417000 - 고양이 : 422400 - 기타
		 * : 429900 urlBuilder.append("&" + URLEncoder.encode("kind","UTF-8") + "=" +
		 * URLEncoder.encode("", "UTF-8")); 품종코드 (품종 조회 OPEN API 참조)
		 * urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" +
		 * URLEncoder.encode("", "UTF-8")); 시도코드 (시도 조회 OPEN API 참조)
		 * urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" +
		 * URLEncoder.encode("", "UTF-8")); 시군구코드 (시군구 조회 OPEN API 참조)
		 * urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" +
		 * URLEncoder.encode("", "UTF-8")); 보호소번호 (보호소 조회 OPEN API 참조)
		 * urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" +
		 * URLEncoder.encode("notice", "UTF-8")); 상태 - 전체 : null(빈값) - 공고중 : notice -
		 * 보호중 : protect urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") +
		 * "=" + URLEncoder.encode("1", "UTF-8")); 페이지 번호 urlBuilder.append("&" +
		 * URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10",
		 * "UTF-8")); 페이지당 보여줄 개수 urlBuilder.append("&" +
		 * URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode("Y",
		 * "UTF-8")); 중성화여부
		 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect(); // 이게 api냐....
//		var desertionNo = $(data).find('item').find('desertionNo')[index]; //유기번호
//     	var age= $(data).find('item').find('age')[index];				   //나이
//     	var happendate= $(data).find('item').find('happenDt')[index];	   //잃어버린날
//     	var findplace= $(data).find('item').find('happenPlace')[index];	   //발견된날
//     	var kind= $(data).find('item').find('kindCd')[index];			   //품종
//     	var color= $(data).find('item').find('colorCd')[index];			   //색상
//     	var weight= $(data).find('item').find('weight')[index];			   //무게
//     	var Feature= $(data).find('item').find('specialMark')[index];	   //특징
//     	var careNM= $(data).find('item').find('careNm')[index];			   //보호소이름
//     	var careTel= $(data).find('item').find('careTel')[index];		   //보호소 전화번호
//     	var careAddr= $(data).find('item').find('careAddr')[index];		   //보호 장소
//     	var office= $(data).find('item').find('chargeNm')[index];		   //담당자
//     	var officetel= $(data).find('item').find('officetel')[index]; 	   //담당자 연락처
//     	var processState= $(data).find('item').find('processState')[index];//현재 상태
//     	var filename= $(data).find('item').find('filename')[index]; 	   //썸네일 사진 경로
//     	var popfile= $(data).find('item').find('popfile')[index];		   //사진 경로
//     	var sex= $(data).find('item').find('sexCd')[index];				   //성별
//     	var neuter= $(data).find('item').find('neuterYn')[index];		   //중성화 여부
//     	var notice= $(data).find('item').find('specialMark')[index];	   //특이사항
//     	var noticeNo= $(data).find('item').find('noticeNo')[index];		   //공고번호
//     	var noticeSdt= $(data).find('item').find('noticeSdt')[index];	   //공고시작일
//     	var noticeEdt= $(data).find('item').find('noticeEdt')[index];	   //공고종료일

		String[] data = (sb.toString()).split(">");
		List<AnimalVO> alist = new ArrayList<>();
		AnimalVO vo = null;
		for (int i = 0; i < data.length; i++) {
			// data[i] += (">");
			if (data[i].equals("<item")) {
				vo = new AnimalVO();
				// System.out.println(data[i]);
			} else if (data[i].contains("</desertionNo")) {
				vo.setDesertionNo(data[i].split("<")[0]);
				System.out.println("qweeeeeeeeee" + vo.getDesertionNo());
			} else if (data[i].contains("</age")) {
				vo.setAge(data[i].split("<")[0]);
				System.out.println(vo.getDesertionNo());
			} else if (data[i].contains("</happenDt")) {
				vo.setHappendate(data[i].split("<")[0]);
				System.out.println(vo.getHappendate());
			} else if (data[i].contains("</happenPlace")) {
				vo.setFindplace(data[i].split("<")[0]);
				System.out.println(vo.getFindplace());
			} else if (data[i].contains("</kindCd")) {
				vo.setKind(data[i].split("<")[0]);
				System.out.println(vo.getKind());
			} else if (data[i].contains("</colorCd")) {
				vo.setColor(data[i].split("<")[0]);
				System.out.println(vo.getColor());
//		     	var weight= $(data).find('item').find('weight')[index];			   //무게
//		     	var Feature= $(data).find('item').find('specialMark')[index];	   //특징
//		     	var careNM= $(data).find('item').find('careNm')[index];			   //보호소이름
//		     	var careTel= $(data).find('item').find('careTel')[index];		   //보호소 전화번호
//		     	var careAddr= $(data).find('item').find('careAddr')[index];		   //보호 장소
//		     	var office= $(data).find('item').find('chargeNm')[index];		   //담당자
//		     	var officetel= $(data).find('item').find('officetel')[index]; 	   //담당자 연락처
//		     	var processState= $(data).find('item').find('processState')[index];//현재 상태
//		     	var filename= $(data).find('item').find('filename')[index]; 	   //썸네일 사진 경로
//		     	var popfile= $(data).find('item').find('popfile')[index];		   //사진 경로
//		     	var sex= $(data).find('item').find('sexCd')[index];				   //성별
//		     	var neuter= $(data).find('item').find('neuterYn')[index];		   //중성화 여부
//		     	var notice= $(data).find('item').find('specialMark')[index];	   //특이사항
//		     	var noticeNo= $(data).find('item').find('noticeNo')[index];		   //공고번호
//		     	var noticeSdt= $(data).find('item').find('noticeSdt')[index];	   //공고시작일
//		     	var noticeEdt= $(data).find('item').find('noticeEdt')[index];	   //공고종료일
			} else if (data[i].contains("</weight")) {
				vo.setWeight(data[i].split("<")[0]);
			} else if (data[i].contains("</specialMark")) {
				vo.setFeature(data[i].split("<")[0]);
			} else if (data[i].contains("</careNm")) {
				vo.setCareNM(data[i].split("<")[0]);
			} else if (data[i].contains("</careTel")) {
				vo.setCareTel(data[i].split("<")[0]);
			} else if (data[i].contains("</careAddr")) {
				vo.setCareAddr(data[i].split("<")[0]);
			} else if (data[i].contains("</chargeNm")) {
				vo.setOffice(data[i].split("<")[0]);
			} else if (data[i].contains("</officetel")) {
				vo.setOfficetel(data[i].split("<")[0]);
			} else if (data[i].contains("</processState")) {
				vo.setProcessState(data[i].split("<")[0]);
			} else if (data[i].contains("</filename")) {
				vo.setFilename(data[i].split("<")[0]);
			} else if (data[i].contains("</popfile")) {
				vo.setPopfile(data[i].split("<")[0]);
			} else if (data[i].contains("</sexCd")) {
				vo.setSex(data[i].split("<")[0]);
			} else if (data[i].contains("</neuterYn")) {
				vo.setNeuter(data[i].split("<")[0]);
			} else if (data[i].contains("</specialMark")) {
				vo.setNotice(data[i].split("<")[0]);
			} else if (data[i].contains("</noticeNo")) {
				vo.setNoticeNo(data[i].split("<")[0]);
			} else if (data[i].contains("</noticeSdt")) {
				vo.setNoticeSdt(data[i].split("<")[0]);
			} else if (data[i].contains("</noticeEdt")) {
				vo.setNoticeEdt(data[i].split("<")[0]);
			} else if (data[i].equals("</item")) {
				alist.add(vo);
			}
		}
		/*for (int j = 0; j < alist.size(); j++) {
			System.out.println(alist.get(j).toString());
		}*/
		HttpSession session = request.getSession();  
		session.setAttribute("alist", alist);
		return "/jsp/menu/LostPetList.jsp";
	}

}
