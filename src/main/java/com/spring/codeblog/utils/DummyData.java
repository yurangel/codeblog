package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    @PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Yury Jose");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Este texto pode ser bem grande assim pode ser verificado a eficiencia do programa em salvar esse tipo de texto, mesmo que ele fosse curto ainda assim seria bem eficiente em salvar. Ao criar esta classe foram usados recursos do spring boot, spring jpa, spring security entre outros.");

        Post post2 = new Post();
        post2.setAutor("Yury Sacilotto");
        post2.setData(LocalDate.now().minusMonths(1));
        post2.setTitulo("API REST");
        post2.setTexto("Este texto pode ser bem grande assim pode ser verificado a eficiencia do programa em salvar esse tipo de texto, mesmo que ele fosse curto ainda assim seria bem eficiente em salvar. Ao criar esta classe foram usados recursos do spring boot, spring jpa, spring security entre outros.");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList){
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
