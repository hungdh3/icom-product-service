package com.icom.product.kafka;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemCreatedEvent {
    private String id;
    private String itemRef;
    private String transactionId;
    private Integer itemQuality;
    private String transactionStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "ItemCreatedEvent{" +
                "id=" + id +
                ", itemRef=" + itemRef +
                ", transactionId=" + transactionId +
                ", itemQuality=" + itemQuality +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}