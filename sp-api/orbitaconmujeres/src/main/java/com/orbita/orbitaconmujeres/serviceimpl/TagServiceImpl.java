package com.orbita.orbitaconmujeres.serviceimpl;



import java.util.Optional;
import java.util.Set;
import com.orbita.orbitaconmujeres.model.Tag;
import com.orbita.orbitaconmujeres.repository.TagRepository;
import com.orbita.orbitaconmujeres.service.TagService;




public class TagServiceImpl implements TagService{

	TagRepository tagRepository;
	
	

	@Override
	public Tag createTag(Tag tag) {
		Optional<Tag> optionalTag = tagRepository.findById(tag.getIdTag());
		if( optionalTag.isPresent()) {
			throw new IllegalStateException("Tag already exist whith id " + tag.getIdTag());
		}
		// TODO Verificar si los atributos son válidos
		tag.setActive(true); // activar cliente
		tag.setIdTag(null); // forzar la creación del cliente		
		Tag newTag = tagRepository.save( tag );
		return newTag;
	}

	
	@Override
	public Tag getTagById(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
		if( optionalTag.isEmpty()) {
			throw new IllegalStateException("Tag does not exist with id " + id);
		}
		Tag existingTag = optionalTag.get();
		return existingTag ;
	}

	@Override
	public Tag updateTag(Tag tag, Long id) {
		// TODO verificar los nuevos atributos a cambiar
		Tag existingTag = getTagById(id);
		existingTag.setIdTag( tag.getIdTag() );
				return tagRepository.save(existingTag);
			}

	@Override
	public void deleteTag(Long id) {
		Tag existingTag = getTagById(id);
		existingTag.setActive(false); // desactivar al usuario
		tagRepository.save(existingTag);
	}


	@Override
	public Set<Tag> getAllTag(boolean isActive) {
		Set<Tag> tag;
		if( isActive ) {
			tag = tagRepository.findAllByActiveTrue();
		} else {
			tag = tagRepository.findAllByActiveFalse();
		}
		return tag;
	}

	
	
}
