package com.javarush.hibernate_project.services;

import com.javarush.hibernate_project.command.TagCommand;
import com.javarush.hibernate_project.dto.TagDTO;

import java.util.List;
import java.util.Set;

public interface TagService {
    void save(TagCommand tagCommand);

    void delete(String name);

    void update(String tagName, TagCommand tagCommand);

    TagDTO getByName(String name);

    List<TagDTO> getAll();

    Set<TagDTO> getTagsByIds(Set<Long> ids);
}
