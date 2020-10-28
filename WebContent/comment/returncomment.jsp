<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${colist}" var="board">
	<div style="background-color: #ffffff;">
		<table style="width: 100%;">
			<tr>
				<th width="60%"><span style="font-size: 23px;">${board.writer}</span><span
					style="color: #888888;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${board.reg_date}</span><br>&nbsp;${board.pet_comment}
				</td>
				<th width="40%">
					<span style="float: right">
					<button class="btn" type="button" data-toggle="collapse"
						data-target="#${board.no}" aria-expanded="false"
						aria-controls="collapseExample" style="float: right">답글</button>
						<c:if test="${userVO.id eq board.writer}">
						<button class="btn">수정</button onclick="asdf">&nbsp;
						<button class="btn">삭제</button>&nbsp;&nbsp;</span>	
									
					</c:if>
				</td>
			</tr>
			<hr>
		</table>
		<c:forEach items="${colist2}" var="board2">
			<c:if test="${board.no eq board2.parrent_no}">
				<table style="margin-left: 15px;">
					<tr>
						<hr width="95%">
						<th width="1%">
						</th>
						<th width="44%"><span style="font-size: 18px;">${board2.writer}</span><br>&nbsp;${board2.pet_comment}
						</td>
						<th width="10%">${board2.reg_date}
						</td>
					</tr>
				</table>

			</c:if>
		</c:forEach>
	</div>
	<div class="collapse" id="${board.no}">
		<table style="margin-top:8px;">
				<tr>
				<td width="3%">
					<span style="font-size: 22px;color: #888888">┖</span><br><br>
				</td>
				<td width="90%">
				<textarea class="form-control" id="co${board.no}" rows="2" cols="170" name="content" id="comment"></textarea>
				</td>
				<td width="7%">
				<input class="btn"
					style="font-size: large; background-color: #B9826E; color: #ffffff;float:right;margin-top:8px;"
					type="button" id="commentbtn" value="등록" onclick="ajaxjs(${board.no});">&nbsp;&nbsp;
		</div><br><br></td>
		</tr>
		</table>
<%-- 		<textarea class="form-control" rows="2" cols="100" name="content"
			id="co${board.no}"></textarea>
		<input class="btn"
			style="font-size: large; background-color: #B9826E; color: #ffffff"
			type="button" value="등록" onclick="ajaxjs(${board.no});">&nbsp;&nbsp; --%>
	</div>
	<br>
</c:forEach>