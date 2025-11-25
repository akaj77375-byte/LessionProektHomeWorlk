package service;

import models.Group;

import java.util.List;

public interface GroupService {
    void addGroup(Group group);
    Group getGroupByName(String groupName);
    void updateGroupByName(String GroupName,String newGroupName);
    List<Group> getAllGroups();
    void deleteByName(String groupName);
}
