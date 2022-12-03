package com.javarush.hibernate_project.services.impl;

import com.javarush.hibernate_project.command.TagCommand;
import com.javarush.hibernate_project.dto.TagDTO;
import com.javarush.hibernate_project.mapper.TagMapper;
import com.javarush.hibernate_project.model.Tag;
import com.javarush.hibernate_project.repositories.TagRepository;
import com.javarush.hibernate_project.services.TagService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class TagServiceImpl implements TagService {

    private final Logger logger = LogManager.getLogger(TagServiceImpl.class);

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
        this.tagMapper = TagMapper.INSTANCE;
    }

    @Override
    public void save(TagCommand tagCommand) {
        Tag tag = tagMapper.mapToEntity(tagCommand);
        tagRepository.save(tag);
        logger.info("Tag saved {}", tag);
    }

    @Override
    public void delete(String name) {
        tagRepository.deleteByName(name);
        logger.info("Tag deleted {}", name);
    }

    @Override
    public void update(String tagName, TagCommand tagCommand) {
        Tag tag = tagRepository.findTagByName(tagName)
                .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
        tagRepository.update(tag.getId(), tagCommand);
        logger.info("Tag updated {}", tag);
    }

    @Override
    public TagDTO getByName(String name) {
        return tagRepository.findTagByName(name)
                .map(tagMapper::mapToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
    }

    @Override
    public List<TagDTO> getAll() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
