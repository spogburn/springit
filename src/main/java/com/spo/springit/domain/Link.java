package com.spo.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Link extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    /// comments (has many)
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }


}

