package ecoandrich.backend1st.dto;

import java.util.List;
public record PublicDataResponse(
        Body body
) {
    public record Body(
            BsListDto items
    ) {
    }
}
