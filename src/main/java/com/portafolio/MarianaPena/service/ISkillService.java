
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Skill;
import java.util.List;

public interface ISkillService {
    public List<Skill> getSkills();
    public void saveSkill (Skill perso);
    public void deleteSkill (Long id);
    public Skill findSkill (Long id);
    
}
