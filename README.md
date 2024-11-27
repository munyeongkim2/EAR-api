
# API 명세서

## 상태 코드 및 응답 메시지
- **200 OK**: 요청이 성공적으로 처리되었습니다.
- **400 Bad Request**: 잘못된 요청 파라미터.
- **500 Internal Server Error**: 서버 내부 오류 발생.

## 기본 페이지 값
- **기본 페이지 크기**: 10
- **기본 페이지 번호**: 0

---

## 1. DepartmentController

### 1.1. GET /api/v1/departments/info
- **설명**: 부서 정보를 페이지네이션하여 조회
- **Request Parameters**:
    - `page` (int, default: 0): 페이지 번호 (0부터 시작)
    - `size` (int, default: 10): 페이지 크기
- **Response**:
  ```json
  {
    "body": {
      "content": [
        {
          "departmentName": "Administration",
          "address": "98199, 2004 Charade Rd, Seattle, Washington, United States of America, Americas"
        },
        ...
      ],
      "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        ...
      },
      "totalElements": 27,
      "totalPages": 3,
      "last": false,
      "size": 10,
      "number": 0,
      "first": true
    },
    "header": {
      "isSuccessful": true,
      "resultMessage": "SUCCESS"
    }
  }
  ```

### 1.2. PUT /api/v1/departments/{departmentId}/salary/increase
- **설명**: 부서의 급여를 일정 비율로 인상
- **Request Parameters**:
    - `departmentId` (Integer): 부서 ID (URL 경로 변수)
    - `percentage` (Double): 급여 인상 비율 (쿼리 파라미터)
- **Response**:
  ```json
  {
    "body": null,
    "header": {
      "isSuccessful": true,
      "resultMessage": "SUCCESS"
    }
  }
  ```

---

## 2. EmployeeController

### 2.1. GET /api/v1/employees/{employeeId}/history
- **설명**: 특정 사원의 이력 정보 조회
- **Request Parameters**:
    - `employeeId` (Integer): 사원 ID
- **Response**:
  ```json
  {
    "body": [
      {
        "employeeId": 101,
        "startDate": "1989-09-21",
        "endDate": "1993-10-27",
        "job": "Public Accountant",
        "department": "Accounting"
      },
      ...
    ],
    "header": {
      "isSuccessful": true,
      "resultMessage": "SUCCESS"
    }
  }
  ```

### 2.2. GET /api/v1/employees/{employeeId}/current
- **설명**: 특정 사원의 현재 정보 조회
- **Request Parameters**:
    - `employeeId` (Integer): 사원 ID
- **Response**:
  ```json
  {
    "body": {
      "employeeId": 101,
      "employeeName": "John Doe",
      "email": "john.doe@example.com",
      "phoneNumber": "123-456-7890",
      "hireDate": "2020-01-01",
      "salary": 50000.00,
      "commissionPct": 0.10,
      "managerName": "Lex De Haan",
      "department": "Administration",
      "job": "Accountant"
    },
    "header": {
      "isSuccessful": true,
      "resultMessage": "SUCCESS"
    }
  }
  ```

---
## 3. PublicDataController

### 3.1. GET /api/v1/public-data
**Description**: 공공 데이터를 페이지네이션하여 조회. 대구 버스 정류장 데이터 사용

**Request Parameters**:
- `page` (int, default: 0): 페이지 번호 (0부터 시작)
- `size` (int, default: 10): 페이지 크기

**Response**:
- `Page<BsDto>`: 버스 정류장 데이터 리스트

### 3.2. POST /api/v1/public-data
**Description**: 버스 정류장 데이터 DB 저장 API

**Request Parameters**: 없음

**Response**:
  ```json
  {
    "body": null,
    "header": {
      "isSuccessful": true,
      "resultMessage": "SUCCESS"
    }
  }
  ```
