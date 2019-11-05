package mate.academy.boot.springboottest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private Integer year;

    @NotNull
    @NotEmpty
    private Double price;

    public BookDto(String title, Integer year, Double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }
}
