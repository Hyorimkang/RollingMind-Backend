package RollingRolling.RollingMindBackend.dto.room;

import RollingRolling.RollingMindBackend.domain.room.Room;
import RollingRolling.RollingMindBackend.domain.room.RoomOpen;
import RollingRolling.RollingMindBackend.domain.room.RoomParticipationRequest;
import RollingRolling.RollingMindBackend.domain.room.RoomTemplateType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RoomResponse {
    private Long id;
    private String roomId;
    private int hostId;
    private RoomOpen open;
    private RoomParticipationRequest participantRequest;
    private String title;
    private String content;
    private LocalDateTime releaseDate;
    private RoomTemplateType templateType;
    private int participantsCount;

    public RoomResponse(Room room, long participantsCount) {
        this.id = room.getIdx();
        this.roomId = room.getRoomId();
        this.hostId = room.getHostId();
        this.open = room.getOpen();
        this.participantRequest = room.getParticipationRequest();
        this.title = room.getTitle();
        this.content = room.getContent();
        this.releaseDate = room.getReleaseDate();
        this.templateType = room.getTemplateType();
        this.participantsCount = (int)participantsCount;
    }
}