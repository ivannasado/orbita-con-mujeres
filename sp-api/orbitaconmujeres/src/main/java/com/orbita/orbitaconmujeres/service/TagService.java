package com.orbita.orbitaconmujeres.service;

import java.util.Set;
import com.orbita.orbitaconmujeres.model.Tag;

public interface TagService {

	Tag createTag(Tag tag);
	Tag getTagById(Long id);
	Tag updateTag(Tag tag, Long id);
	Set<Tag> getAllTag(boolean isActive);
	void deleteTag(Long id);
}
