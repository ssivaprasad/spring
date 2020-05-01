package com.ssp.springmvc.service;

import com.ssp.springmvc.dto.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private static List<Post> posts = new ArrayList<Post>();
    private static int postCount = 3;

    static {
        posts.add(new Post(1, "in28Minutes", "Welcome", "Welcome !!!!", new Date()));
        posts.add(new Post(2, "in28Minutes", "Hello", "Hello !!!!", new Date()));
        posts.add(new Post(3, "in28Minutes", "Hi", "Hi !!!!", new Date()));
    }

    public List<Post> retrievePosts(String user) {
        return posts.stream().filter(post -> post.getPostedBy().equalsIgnoreCase(user)).collect(Collectors.toList());
    }

    public Post retrievePost(Integer id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst().get();
    }

    public void updatePost(Post post) {
        posts.remove(post);
        posts.add(post);
    }

    public void addPost(String postedBy, String title, String content, Date postedDate) {
        posts.add(new Post(++postCount, postedBy, title, content, postedDate));
    }

    public void deletePost(int id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId() == id) {
                iterator.remove();
            }
        }
    }
}