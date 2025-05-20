package model;

import enums.SnakeColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snake {

	private Integer size = 2;
	private SnakeColor color;
	
	@Builder
	public Snake(Integer size) {
		this.size = size;
	}
}
