package SUGGESTION.DTO;

import java.sql.Timestamp;

/**
 * 건의사항 DTO
 */
public class SuggestionDTO {

    /** 건의사항 번호 */
    private long suggestionId;

    /** 제목 */
    private String title;

    /** 내용 */
    private String content;

    /** 작성자 사번 */
    private long writerEmpId;

    /** 작성자명 */
    private String writerName;

    /** 부서코드 */
    private String deptCode;

    /** 상태 */
    private String status;

    /** 조회수 */
    private int viewCount;

    /** 비고 */
    private String remark;

    /** 작성일 */
    private Timestamp createdAt;

    /** 수정일 */
    private Timestamp updatedAt;

    public long getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getWriterEmpId() {
        return writerEmpId;
    }

    public void setWriterEmpId(long writerEmpId) {
        this.writerEmpId = writerEmpId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}