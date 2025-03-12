import java.io.Serializable;

public class EmpDTO implements Serializable {
    private int empNo;       // 사원 번호
    private String empId;    // 아이디
    private String empName;  // 이름
    private String pw;       // 비밀번호
    private String email;    // 이메일
    private String phone;    // 연락처
    private int grade;       // 등급

    // 기본 생성자
    public EmpDTO() {}

    // Getter와 Setter 메서드
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // toString 메서드 (디버깅용)
    @Override
    public String toString() {
        return "EmpDTO{" +
                "empNo=" + empNo +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", grade=" + grade +
                '}';
    }
}
