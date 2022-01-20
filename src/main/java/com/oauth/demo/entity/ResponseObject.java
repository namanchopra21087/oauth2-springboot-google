package com.oauth.demo.entity;

import com.oauth.demo.constants.FasConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Naman
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ResponseObject {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FasConstants.DD_MM_YYYY_HH_MM_SS)
    private LocalDateTime timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String transactionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object metaData;
}
