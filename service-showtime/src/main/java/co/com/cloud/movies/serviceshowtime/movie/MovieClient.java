package co.com.cloud.movies.serviceshowtime.movie;

import co.com.cloud.movies.serviceshowtime.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-movie")
@RequestMapping("/movies")
public interface MovieClient {
    @GetMapping("/{id}")
    Response findById(@PathVariable("id") Long id);
}
