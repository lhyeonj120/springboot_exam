package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

//    @GetMapping("/users")
//    public List<User> retrieveAllUsers(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id){
//        //findById -> Optional<T> 리턴 : 데이터값이 있을 수도 있고 없을 수도 있을 때 사용
//        //안에 User 객체 들어있음. get 메소드로 뽑아내면 됨.
//
//        Optional<User> user = userRepository.findById(id);
//
//        if(!user.isPresent()){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        return EntityModel.of(user.get(),
//                linkTo(methodOn(UserJpaController.class).retrieveAllUsers()).withRel("all-users"));
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id){
//
//        userRepository.deleteById(id);
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User savedUser = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        //200 OK -> 201 OK
//        return ResponseEntity.created(location).build();
//    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostByUser(@PathVariable int id){
//        Optional<User> user = userRepository.findById(id);
//
//        if(!user.isPresent()){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        return user.get().getPosts();
        return postService.retrieveAllPostByUser(id);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post){
//        Optional<User> user = userRepository.findById(id);
//
//        if(!user.isPresent()){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        post.setUser(user.get());
//        Post savedPost = postRepository.save(post);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedPost.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();

        User user = userService.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        post.setUser_id(id);
        postService.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
