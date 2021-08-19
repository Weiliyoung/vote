package com.weiyang.vote.domain.pojo;

public class VoteOption {
    private Integer id;

    private Integer voteId;

    private String optionContent;

    private String pictureUrl;

    public VoteOption(Integer id, Integer voteId, String optionContent, String pictureUrl) {
        this.id = id;
        this.voteId = voteId;
        this.optionContent = optionContent;
        this.pictureUrl = pictureUrl;
    }

    public VoteOption() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent == null ? null : optionContent.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", optionContent='" + optionContent + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}