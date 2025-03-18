<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시설 등록</title>
    <style>
        /* CSS 스타일 */
        body {
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 95%;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
            border: 1px solid black;
            padding: 10px;
        }

        .form {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin-bottom: 20px;
        }

        .form-fields {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .form-row {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            gap: 10px;
        }

        label {
            min-width: 80px;
        }

        input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            flex: 1;
        }

        .buttons {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        button {
            padding: 10px 15px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        .pagination {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            gap: 5px;
        }

        .pagination button {
            padding: 5px 10px;
            border-radius: 5px;
        }

        @media screen and (max-width: 800px) {
            .form-row {
                flex-direction: column;
                align-items: stretch;
                gap: 5px !important;
                /* 모바일에서 간격 조정 */
            }
            .buttons {
                flex-direction: row;
                justify-content: center;
                margin-top: 10px;
            }
            button {
                width: auto;
            }
        }

        .edit-buttons {
            margin-top: 10px;
        }

        .active {
            background-color: #0056b3;
        }

        h1 {
            width: 90%;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>◎ 시설 등록</h1>

        <span class="별">* 모두 기입</span>

        <!-- 검색 폼 -->
        <form method="get" action="p_eq">
            <input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
            <button type="submit">검색</button>
        </form>

        <!-- 등록/수정 폼 -->
        <form method="post" action="p_eq" class="form">
            <div class="form-fields">
                <div class="form-row">
                    <label for="facilityCode">시설 코드<span class="별"> *</span></label> 
                    <input type="text" id="facilityCode" name="facilityCode" required>
                    <label for="facilityManager">관리자<span class="별"> *</span></label> 
                    <input type="text" id="facilityManager" name="facilityManager" required>
                </div>

                <div class="form-row">
                    <label for="installationDate">설치 일자<span class="별"> *</span></label> 
                    <input type="date" id="installationDate" name="installationDate" required> 
                    <label for="facilityName">시설 이름<span class="별"> *</span></label> 
                    <input type="text" id="facilityName" name="facilityName" required>
                </div>

                <div class="form-row">
                    <label for="facilityLocation">시설 위치<span class="별"> *</span></label> 
                    <input type="text" id="facilityLocation" name="facilityLocation" required> 
                    <label for="inspectionCycle">점검 주기<span class="별"> *</span></label> 
                    <input type="text" id="inspectionCycle" name="inspectionCycle" required>
                </div>

                <div class="form-row">
                    <label for="remarks">비고 사항</label> 
                    <input type="text" id="remarks" name="remarks">
                </div>
            </div>

            <!-- 버튼 영역 -->
            <div class="buttons">
                <button type="submit" value="등록" class="buttons">등록</button>
                <button type="button" value="조회" class="buttons" onclick="searchEq()">조회</button>
                <button type="button" class="buttons" id="editSelectedButton">수정</button>
                <button type="button" class="buttons" id="updateButton" style="display: none;" onclick="updateEq()">수정 완료</button>
                <button type="button" class="buttons" id="cancelButton" style="display: none;">취소</button>
                <button type="submit" value="삭제" class="buttons" name="action">삭제</button>
            </div>

        </form>

        <!-- 시설 목록 테이블 -->
        <table>
            <thead>
                <tr>
                    <th><input type="checkbox" id="selectAll"></th>
                    <th>시설 코드</th>
                    <th>관리자</th>
                    <th>설치 일자</th>
                    <th>시설 이름</th>
                    <th>점검 주기</th>
                    <th>시설 위치</th>
                    <th>비고 사항</th>
                </tr>
            </thead>

            <tbody id="table-body">
                <c:forEach var="dto" items="${resultList}">
                    <tr>
                        <td><input type="checkbox" name="check" value="${dto.facility_code}"></td>
                        <td>${dto.facility_code}</td>
                        <td>${dto.facility_manager}</td>
                        <td>${dto.installation_date}</td>
                        <td>${dto.facility_name}</td>
                        <td>${dto.inspection_cycle}</td>
                        <td>${dto.facility_location}</td>
                        <td>${dto.remarks}</td>
                        <td><button type="button" onclick="showUpdateForm('${dto.facility_code}', '${dto.facility_manager}', '${dto.installation_date}', '${dto.facility_name}', '${dto.facility_location}', '${dto.inspection_cycle}', '${dto.remarks}')">수정</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 수정 폼 -->
        <div id="updateForm" style="display: none;">
            <form method="post" action="p_eq">
                <input type="hidden" name="action" value="수정">
                <table>
                    <tr>
                        <th>시설 코드</th>
                        <th>관리자</th>
                        <th>설치 일자</th>
                        <th>시설 이름</th>
                        <th>시설 위치</th>
                        <th>점검 주기</th>
                        <th>비고 사항</th>
                    </tr>
                    <tr>
                        <td><input type="text" id="updateFacilityCode" name="facilityCode" readonly></td>
                        <td><input type="text" id="updateFacilityManager" name="facilityManager"></td>
                        <td><input type="date" id="updateInstallationDate" name="installationDate"></td>
                        <td><input type="text" id="updateFacilityName" name="facilityName"></td>
                        <td><input type="text" id="updateFacilityLocation" name="facilityLocation"></td>
                        <td><input type="text" id="updateInspectionCycle" name="inspectionCycle"></td>
                        <td><input type="text" id="updateRemarks" name="remarks"></td>
                    </tr>
                </table>
                <button type="submit">수정</button>
                <button type="button" onclick="hideUpdateForm()">취소</button>
            </form>
        </div>

        <script>
            // 항상 오늘 날짜로 하는 스크립트
            document.getElementById('installationDate').value = new Date().toISOString().substring(0, 10);

            // 전체 선택/해제 체크박스 이벤트
            document.getElementById('selectAll').addEventListener('change', function() {
                var checkboxes = document.querySelectorAll('input[name="check"]');
                checkboxes.forEach(function(checkbox) {
                    checkbox.checked = document.getElementById('selectAll').checked;
                });
            });

            // 조회 버튼
            function searchEq() {
                window.location.href = "p_eq";
            }

            // 삭제 버튼 클릭 이벤트
            document.querySelector('input[value="삭제"]').addEventListener('click', function(event) {
                // 배열 초기화
                var selectedChecks = [];
                // 체크된거 전체가져오기를 checkboxes에 담았다  
                var checkboxes = document.querySelectorAll('input[name="check"]:checked');
                // 선택된것들을 selectedChecks는 배열에 추가했다
                checkboxes.forEach(function(checkbox) {
                    selectedChecks.push(checkbox.value);
                });
                // 체크된거 1개 이상이면
                if (selectedChecks.length > 0) {
                    // 체크된 value="${dto.sku_id } 목록을 
                    // 새로운 입력 필드로 추가하여 서버에 전송
                    // 내가 만든 배열에 추가된거에 ,로 구분된 문자열로 결합
                    var form = event.target.closest('form');
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = 'check';
                    input.value = selectedChecks.join(',');
                    form.appendChild(input);
                } else{
                    alert("선택된 항목이 없습니다.");
                    event.preventDefault(); // 폼 제출 방지
                }
            });

            // 수정 버튼 클릭 이벤트
            document.getElementById('editSelectedButton').addEventListener('click', function() {
                var selectedChecks = [];
                var checkboxes = document.querySelectorAll('input[name="check"]:checked');
                checkboxes.forEach(function(checkbox) {
                    selectedChecks.push(checkbox.value);
                });

                if (selectedChecks.length === 1) { // 하나만 선택했을 경우
                    var facilityCode = selectedChecks[0];
                    var selectedRow = document.querySelector('input[name="check"][value="' + facilityCode + '"]').closest('tr');

                    // 선택된 행의 데이터 가져오기
                    var facilityManager = selectedRow.querySelectorAll('td')[2].textContent;
                    var installationDate = selectedRow.querySelectorAll('td')[3].textContent;
                    var facilityName = selectedRow.querySelectorAll('td')[4].textContent;
                    var inspectionCycle = selectedRow.querySelectorAll('td')[5].textContent;
                    var facilityLocation = selectedRow.querySelectorAll('td')[6].textContent;
                    var remarks = selectedRow.querySelectorAll('td')[7].textContent;

                    // 입력 필드에 데이터 표시
                    document.getElementById('updateFacilityCode').value = facilityCode;
                    document.getElementById('updateFacilityManager').value = facilityManager;
                    document.getElementById('updateInstallationDate').value = installationDate;
                    document.getElementById('updateFacilityName').value = facilityName;
                    document.getElementById('updateFacilityLocation').value = facilityLocation;
                    document.getElementById('updateInspectionCycle').value = inspectionCycle;
                    document.getElementById('updateRemarks').value = remarks;

                    // 수정 버튼 및 취소 버튼 표시
                    document.getElementById('updateButton').style.display = 'inline-block';
                    document.getElementById('cancelButton').style.display = 'inline-block';

                    // 수정 모드 설정 (수정 완료 시 필요한 정보)
                    document.getElementById('updateForm').style.display = 'block';
                } else if (selectedChecks.length > 1){
                    alert("수정시 하나의 항목만 선택해주세요.");
                }else {
                    alert("선택된 항목이 없습니다.");
                }
            });

            // 수정 완료 함수
            function updateEq() {
                // AJAX 요청을 사용하여 서버에 수정된 시설 정보 전송
                // 현재는 폼 제출 방식으로 구현되어 있으므로, AJAX로 변경할 필요가 없습니다.
            }

            // 전체 체크기능
            function selectAll(selectAllCheckbox) {
                const checkboxes = document.getElementsByName('check');
                for (let checkbox of checkboxes) {
                    checkbox.checked = selectAllCheckbox.checked;
                }
            }

            function updateSelectAll() {
                const selectAllCheckbox = document.getElementById('selectAll');
                const checkboxes = document.getElementsByName('check');
                selectAllCheckbox.checked = Array.from(checkboxes).every(checkbox => checkbox.checked);
            }

            // 개별 체크박스에 이벤트 리스너 추가
            document.addEventListener('DOMContentLoaded', function() {
                const checkboxes = document.getElementsByName('check');
                for (let checkbox of checkboxes) {
                    checkbox.addEventListener('change', updateSelectAll);
                }
            });

            // 수정 폼 숨기기
            function hideUpdateForm() {
                document.getElementById('updateForm').style.display = 'none';
            }

            // 수정 폼 표시
            function showUpdateForm(facilityCode, facilityManager, installationDate, facilityName, facilityLocation, inspectionCycle, remarks) {
                document.getElementById('updateFacilityCode').value = facilityCode;
                document.getElementById('updateFacilityManager').value = facilityManager;
                document.getElementById('updateInstallationDate').value = installationDate;
                document.getElementById('updateFacilityName').value = facilityName;
                document.getElementById('updateFacilityLocation').value = facilityLocation;
                document.getElementById('updateInspectionCycle').value = inspectionCycle;
                document.getElementById('updateRemarks').value = remarks;

                document.getElementById('updateForm').style.display = 'block';
            }
        </script>
    </div>
</body>

</html>
