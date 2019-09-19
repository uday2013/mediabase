package com.example.mediabase.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MoviesBean moviesBean;

    public MovieController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {

        moviesBean.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable Long id) {
        Movie doomed = moviesBean.find(id);
        if (doomed != null) moviesBean.deleteMovie(doomed);
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key
    )
    {
        return (field != null && key != null) ? moviesBean.count(field, key) : moviesBean.countAll();
    }

    @GetMapping()
    public List<Movie> read(
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "start", required = false) Integer start,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ){
        if (field != null && key != null && start != null && pageSize != null)
            return moviesBean.findRange(field, key, start, pageSize);
        else if (start != null && pageSize != null)
            return moviesBean.findAll(start, pageSize);
        else
            return moviesBean.getMovies();

    }

}
