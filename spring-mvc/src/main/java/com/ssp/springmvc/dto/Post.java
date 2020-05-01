package com.ssp.springmvc.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Post {

    private Integer id;
    private String postedBy;

    @NotNull(message = "Title should not be null or empty")
    @NotEmpty(message = "Title should not be null or empty")
    private String title;

    @NotNull(message = "Content should not be null or empty")
    @NotEmpty(message = "Content should not be null or empty")
    private String content;

    private Date postedDate;

    public Post(Integer id, String postedBy, String title, String content, Date postedDate) {
        this.id = id;
        this.postedBy = postedBy;
        this.title = title;
        this.content = content;
        this.postedDate = postedDate;
    }
}
