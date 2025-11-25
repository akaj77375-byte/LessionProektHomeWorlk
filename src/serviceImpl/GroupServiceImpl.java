package serviceImpl;

import DataBase.Db;
import models.Group;
import service.GroupService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.reflect.Array.set;

public class GroupServiceImpl implements GroupService {
    @Override
    public void addGroup(Group group) {
        Db.groups.add(group);
        System.out.println(group.getGroupName() + "Ийгиликту кошулду");

    }

    @Override
    public Group getGroupByName(String groupName) {
try {
    if (groupName == null||groupName.isBlank()) {
        throw new NullPointerException("Ваше название не должно быть равно нулл!");
    }
    for (Group g : Db.groups) {
        if (g.getGroupName().equalsIgnoreCase(groupName)) {
            return g;
        }
    }
    System.out.println("Нету такой группы с таким названием!");
}catch (NullPointerException e){
    e.getMessage();
}finally {
    System.out.print("(T_T)<(^-^<)");
}
return null;
    }

    @Override
    public void updateGroupByName(String groupName, String newGroupName) {
        try {
            if (groupName == null || newGroupName == null||groupName.isBlank()||newGroupName.isBlank()) {
                throw new NullPointerException("Ваше название не должно быть равно нулл!");
            }
            boolean isTrue = false;
            for (Group g : Db.groups) {
                if (g.getGroupName().equalsIgnoreCase(groupName)) {
                    g.setGroupName(newGroupName);
                    isTrue = true;
                }
            }
            if (!isTrue ) {
                System.out.println("Нету такой группы с таким названием");
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("(T_T)<(^-^<)Л");
        }
}


    @Override
    public List<Group> getAllGroups() {

        return new ArrayList<>(Db.groups);
    }

    @Override
    public void deleteByName(String groupName) {
try{
    if (groupName==null||groupName.isBlank()){
        throw new NullPointerException("Ваше название не должно быть равно нулл!");
    }
        for (int i = 0; i <Db.groups.size() ; i++) {
            if (Db.groups.get(i).getGroupName().equalsIgnoreCase(groupName)) {
                Db.groups.remove(i);
                return;
            }
        }
        System.out.println("Нету такой группы с таким названием");
        }catch (NullPointerException e){
    System.out.println(e.getMessage());
}finally {
    System.out.println("(T_T)<(^-^<)");
        }




    }
}
