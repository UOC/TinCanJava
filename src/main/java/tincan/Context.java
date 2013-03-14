package tincan;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import tincan.json.JSONBase;
import tincan.json.Mapper;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.UUID;

/**
 * Context Class Description
 */
@Data
@NoArgsConstructor
public class Context extends JSONBase {
    private UUID registration;
    private Agent instructor;
    private Agent team;
    private ContextActivities contextActivities;
    private String revision;
    private String platform;
    private String language;
    private SubStatement statement;
    private Extensions extensions;

    public Context(JsonNode jsonNode) throws MalformedURLException {
        this();

        JsonNode registrationNode = jsonNode.path("registration");
        if (! registrationNode.isMissingNode()) {
            this.setRegistration(UUID.fromString(registrationNode.textValue()));
        }

        // TODO: check these for Group
        JsonNode instructorNode = jsonNode.path("instructor");
        if (! instructorNode.isMissingNode()) {
            this.setInstructor(new Agent(instructorNode));
        }

        JsonNode teamNode = jsonNode.path("team");
        if (! teamNode.isMissingNode()) {
            this.setTeam(new Agent(teamNode));
        }

        JsonNode contextActivitiesNode = jsonNode.path("contextActivities");
        if (! contextActivitiesNode.isMissingNode()) {
            this.setContextActivities(new ContextActivities(contextActivitiesNode));
        }

        JsonNode revisionNode = jsonNode.path("revision");
        if (! revisionNode.isMissingNode()) {
            this.setRevision(revisionNode.textValue());
        }

        JsonNode platformNode = jsonNode.path("platform");
        if (! platformNode.isMissingNode()) {
            this.setPlatform(platformNode.textValue());
        }

        JsonNode languageNode = jsonNode.path("language");
        if (! languageNode.isMissingNode()) {
            this.setLanguage(languageNode.textValue());
        }

        JsonNode statementNode = jsonNode.path("statement");
        if (! statementNode.isMissingNode()) {
            this.setStatement(new SubStatement(statementNode));
        }

        JsonNode extensionsNode = jsonNode.path("extensions");
        if (! extensionsNode.isMissingNode()) {
            this.setExtensions(new Extensions(extensionsNode));
        }
    }

    @Override
    public ObjectNode toJSONNode(TCAPIVersion version) {
        ObjectNode node = Mapper.getInstance().createObjectNode();

        if (this.registration != null) {
            node.put("registration", this.getRegistration().toString());
        }
        if (this.instructor != null) {
            node.put("instructor", this.getInstructor().toJSONNode(version));
        }
        if (this.team != null) {
            node.put("team", this.getTeam().toJSONNode(version));
        }
        if (this.contextActivities != null) {
            node.put("contextActivities", this.getContextActivities().toJSONNode(version));
        }
        if (this.revision != null) {
            node.put("revision", this.getRevision());
        }
        if (this.platform != null) {
            node.put("platform", this.getPlatform());
        }
        if (this.language != null) {
            node.put("language", this.getLanguage());
        }
        if (this.statement != null) {
            node.put("statement", this.getStatement().toJSONNode(version));
        }
        if (this.extensions != null) {
            node.put("extensions", this.getExtensions().toJSONNode(version));
        }

        return node;
    }
}
