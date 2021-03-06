package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Comments {
    @Id
    private String id;

    @Column(name = "father_comment_id")
    private String fatherCommentId;

    @Column(name = "to_user_id")
    private String toUserId;

    /**
     * id
     */
    @Column(name = "video_id")
    private String videoId;

    /**
     * id
     */
    @Column(name = "from_user_id")
    private String fromUserId;

    @Column(name = "create_time")
    private Date createTime;

    private String comment;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return father_comment_id
     */
    public String getFatherCommentId() {
        return fatherCommentId;
    }

    /**
     * @param fatherCommentId
     */
    public void setFatherCommentId(String fatherCommentId) {
        this.fatherCommentId = fatherCommentId;
    }

    /**
     * @return to_user_id
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * @param toUserId
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取id
     *
     * @return video_id - id
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * 设置id
     *
     * @param videoId id
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     * 获取id
     *
     * @return from_user_id - id
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * 设置id
     *
     * @param fromUserId id
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}