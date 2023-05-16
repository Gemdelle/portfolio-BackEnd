package com.backend.portfolio.service;

import com.backend.portfolio.dto.*;
import com.backend.portfolio.dto.request.LoginDTO;
import com.backend.portfolio.dto.request.UserCreationDTO;
import com.backend.portfolio.mappers.UserMapper;
import com.backend.portfolio.model.*;
import com.backend.portfolio.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AboutRepository aboutRepository;
    private final InstitutionRepository institutionRepository;
    private final CourseRepository courseRepository;
    private final AcademyRepository academyRepository;
    private final LanguageRepository languageRepository;
    private final EducationRepository educationRepository;
    private final ProjectRepository projectRepository;
    private final WorkExperienceRepository workExperienceRepository;
    private final SkillRepository skillRepository;
    private final SkillsRepository skillsRepository;
    private final RoleRepository roleRepository;
    private final SubProjectRepository subProjectRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, AboutRepository aboutRepository, InstitutionRepository institutionRepository, CourseRepository courseRepository, AcademyRepository academyRepository, LanguageRepository languageRepository, EducationRepository educationRepository, ProjectRepository projectRepository, WorkExperienceRepository workExperienceRepository, SkillRepository skillRepository, SkillsRepository skillsRepository, RoleRepository roleRepository, SubProjectRepository subProjectRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.aboutRepository = aboutRepository;
        this.institutionRepository = institutionRepository;
        this.courseRepository = courseRepository;
        this.academyRepository = academyRepository;
        this.languageRepository = languageRepository;
        this.educationRepository = educationRepository;
        this.projectRepository = projectRepository;
        this.workExperienceRepository = workExperienceRepository;
        this.skillRepository = skillRepository;
        this.skillsRepository = skillsRepository;
        this.roleRepository = roleRepository;
        this.subProjectRepository = subProjectRepository;
    }

    @Override
    @Transactional
    public User createUser(UserCreationDTO userCreationDTO) {
        User user = createUserWithDefaultValues();
        About savedAbout = saveAbout(userCreationDTO.getAbout(), user);
        Education savedEducation = saveEducation(userCreationDTO, user);
        List<Academy> savedAcademies = saveAcademies(userCreationDTO.getAcademies(), user);
        List<Project> savedProjects = saveProjects(userCreationDTO.getProjects(), user);
        WorkExperience savedWorkExperience = saveWorkExperiences(userCreationDTO.getExperience(), user);
        List<Skill> savedSoftSkills = saveSkills(userCreationDTO.getSkills().getSoft(), user);
        List<Skill> savedHardSkills = saveSkills(userCreationDTO.getSkills().getHard(), user);
        Skills savedSkills = saveSkills(savedSoftSkills, savedHardSkills, user);
        setUserDetails(user, savedAbout, savedEducation, savedAcademies, savedProjects, savedWorkExperience, savedSkills);
        return userRepository.save(user);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    return user.map(userMapper::toDto);
    }

    @Override
    public User loginUser(LoginDTO loginDTO) {
        return userRepository.findAll().stream().filter(user -> isValidLoginForUser(loginDTO, user))
                .findFirst()
                .orElseThrow();
    }

    @Override
    @Transactional
    public void updateUserById(Long userId, UserCreationDTO userCreationDTO) {
        User user = userRepository.findById(userId).orElseThrow();
        About about = updateAbout(userCreationDTO.getAbout(), user);
        Education updatedEducation = updateEducation(userCreationDTO.getEducation(), user);
        List<Academy> updatedAcademies = updateAcademies(userCreationDTO.getAcademies(), user);
        List<Project> updatedProjects = updateProjects(userCreationDTO.getProjects(), user);
        WorkExperience updatedWorkExperience = updateWorkExperiences(userCreationDTO.getExperience(), user);
        Skills updatedSkills = updateSkills(userCreationDTO, user);
        setUserDetails(user, about, updatedEducation, updatedAcademies, updatedProjects, updatedWorkExperience, updatedSkills);
        userRepository.save(user);
    }

    private static boolean isValidLoginForUser(LoginDTO loginDTO, User user) {
        return Objects.equals(user.getEmailAddress(), loginDTO.getEmail()) && Objects.equals(user.getPassword(), loginDTO.getPassword());
    }

    // UPDATES
    private About updateAbout(AboutDTO aboutDTO, User user) {
        About about = aboutRepository.findByUser(user);
        about.setLogicDescription(aboutDTO.getLogic_description());
        about.setBannerUrl(aboutDTO.getBanner_url());
        about.setCreativityDescription(aboutDTO.getCreativity_description());
        about.setProfilePictureUrl(aboutDTO.getProfile_picture_url());
        about.setProfileTitle(aboutDTO.getProfile_title());
        return aboutRepository.save(about);
    }

    private List<Institution> updateInstitutions(List<InstitutionDTO> institutionDTOs, Education education) {
        List<Institution> savedInstitutions = institutionRepository.findByEducation(education);
        List<Institution> updatedInstitutions = new ArrayList<>();
        for (int i = 0; i < institutionDTOs.size(); i++) {
            InstitutionDTO institutionDTO = institutionDTOs.get(i);
            Institution institution;

            if (i < savedInstitutions.size()) {
                institution = savedInstitutions.get(i);
            } else {
                institution = new Institution();
                savedInstitutions.add(institution);
            }

            institution.setCertificate(institutionDTO.getCertificate());
            institution.setName(institutionDTO.getName());
            institution.setLogo(institutionDTO.getLogo());
            institution.setTitle(institutionDTO.getTitle());
            institution.setFrom_date(institutionDTO.getFrom());
            institution.setTo_date(institutionDTO.getTo());
            institution.setEducation(education);

            Institution savedInstitution = institutionRepository.save(institution);
            updatedInstitutions.add(savedInstitution);
        }

        return updatedInstitutions;
    }

    private List<Language> updateLanguages(List<LanguageDTO> languageDTOs, Education education){
        List<Language> savedLanguages = languageRepository.findByEducation(education);
        List<Language> updatedLanguages = new ArrayList<>();

        for (int i = 0; i < languageDTOs.size(); i++) {
            LanguageDTO languageDTO = languageDTOs.get(i);
            Language language;

            if (i < savedLanguages.size()) {
                language = savedLanguages.get(i);
            } else {
                language = new Language();
                savedLanguages.add(language);
            }

            language.setName(languageDTO.getName());
            language.setCertificate(languageDTO.getCertificate());
            language.setBackgroundD(languageDTO.getBackground());
            language.setLevel(languageDTO.getLevel());
            language.setTitle(languageDTO.getTitle());
            language.setFull(languageDTO.getFull());
            language.setEmptyD(languageDTO.getEmpty());
            language.setEducation(education);

            Language updatedLanguage = languageRepository.save(language);
            updatedLanguages.add(updatedLanguage);
        }

        return updatedLanguages;
    }

    private Education updateEducation(EducationDTO educationDTO, User user){
        Education education = educationRepository.findByUser(user);
        List<Institution> updatedInstitutions = updateInstitutions(educationDTO.getInstitutions(), education);
        List<Language> updatedLanguages = updateLanguages(educationDTO.getLanguages(), education);
        education.setInstitutions(updatedInstitutions);
        education.setLanguages(updatedLanguages);
        return educationRepository.save(education);
    }

    private List<Course> updateCourses(List<CourseDTO> courseDTOs, Academy academy) {
        courseRepository.deleteAllByAcademy(academy);
        List<Course> updatedCourses = new ArrayList<>();

        for (CourseDTO courseDTO : courseDTOs) {
            Course course = new Course();
            course.setAcademy(academy);
            course.setName(courseDTO.getName());
            course.setCertificate(courseDTO.getCertificate());
            course.setDescription(courseDTO.getDescription());

            Course updatedCourse = courseRepository.save(course);
            updatedCourses.add(updatedCourse);
        }
        return updatedCourses;
    }

    private List<Academy> updateAcademies(List<AcademyDTO> academyDTOs, User user) {
        List<Academy> academies = academyRepository.findByUser(user);
        List<Academy> updatedAcademies = new ArrayList<>();

        for (int i = 0; i < academyDTOs.size(); i++) {
            AcademyDTO academyDTO = academyDTOs.get(i);
            Academy academy;

            if (i < academies.size()) {
                academy = academies.get(i);
            } else {
                academy = new Academy();
                academy.setUser(user);
            }

             List<Course> updatedCourses = updateCourses(academyDTO.getCourses(), academy);
            academy.setName(academyDTO.getName());
            academy.setLogo(academyDTO.getLogo());
            academy.setShield(academyDTO.getShield());
             academy.setCourses(updatedCourses);

            Academy updatedAcademy = academyRepository.save(academy);
            updatedAcademies.add(updatedAcademy);
        }

        return updatedAcademies;
    }

    private List<Subproject> updateSubprojects(List<SubprojectDTO> subprojectsDTOs, Project project){
        if(subprojectsDTOs == null || subprojectsDTOs.isEmpty()){
            return Collections.emptyList();
        }

        subProjectRepository.deleteAllByProject(project);
        List<Subproject> updateSubProjects = new ArrayList<>();

        for(SubprojectDTO  subprojectDTO : subprojectsDTOs){
            Subproject subproject = new Subproject();
            subproject.setProject(project);
            subproject.setBackground(subprojectDTO.getBackground());
            subproject.setName(subprojectDTO.getName());
            subproject.setNumber(subprojectDTO.getNumber());
            subproject.setFccStyleUrl(subprojectDTO.getFcc_style_url());
            subproject.setFccStyleDescription(subprojectDTO.getFcc_style_description());
            subproject.setMyStyleUrl(subprojectDTO.getMy_style_url());
            subproject.setMyStyleDescription(subprojectDTO.getMy_style_description());

            subProjectRepository.save(subproject);
            updateSubProjects.add(subproject);
        }

        return updateSubProjects;
    }
    private List<Project> updateProjects(List<ProjectDTO> projectDTOs, User user) {
        List<Project> projects = projectRepository.findByUser(user);
        List<Project> updatedProjects = new ArrayList<>();

        for (int i = 0; i < projectDTOs.size(); i++) {
            ProjectDTO projectDTO = projectDTOs.get(i);
            Project project;

            if (i < projects.size()) {
                project = projects.get(i);
            } else {
                project = new Project();
                project.setUser(user);
            }

            project.setTitle(projectDTO.getTitle());
            project.setProjectUrl(projectDTO.getData().getProject_url());
            project.setType(projectDTO.getType());
            project.setNumber(String.valueOf(projectDTO.getNumber()));
            project.setDescription(projectDTO.getDescription());
            project.setTags(projectDTO.getTags());
            project.setBackground(projectDTO.getData().getBackground());
            project.setSubprojects(updateSubprojects(projectDTO.getData().getSubprojects(), project));

            Project updatedProject = projectRepository.save(project);
            updatedProjects.add(updatedProject);
        }

        return updatedProjects;
    }

    private List<Role> updateRoles(List<RoleDTO> roleDTOs, WorkExperience workExperience) {
        List<Role> savedRoles = roleRepository.findByWorkExperience(workExperience);
        List<Role> updatedRoles = new ArrayList<>();
        for (int i = 0; i < roleDTOs.size(); i++) {
            RoleDTO roleDTO = roleDTOs.get(i);
            Role role;

            if (i < savedRoles.size()) {
                role = savedRoles.get(i);
            } else {
                role = new Role();
                savedRoles.add(role);
            }

            role.setName(roleDTO.getName());
            role.setDescription(roleDTO.getDescription());
            role.setWorkExperience(workExperience);

            Role updatedRole =  roleRepository.save(role);
            updatedRoles.add(updatedRole);
        }

        return updatedRoles;
    }

    private WorkExperience updateWorkExperiences(ExperienceDTO workExperienceDTO, User user) {
        WorkExperience savedWorkExperience = workExperienceRepository.findByUser(user);
        savedWorkExperience.setLogo(workExperienceDTO.getLogo());
        savedWorkExperience.setDescription(workExperienceDTO.getDescription());
        savedWorkExperience.setStartDate(workExperienceDTO.getFrom());
        savedWorkExperience.setEndDate(workExperienceDTO.getTo());
        savedWorkExperience.setStudioName(workExperienceDTO.getStudio_name());
        savedWorkExperience.setThumbnail(workExperienceDTO.getThumbnail());
        savedWorkExperience.setThumbnailUrl(workExperienceDTO.getThumbnail_url());
        List<Role> savedRoles = updateRoles(workExperienceDTO.getRoles(), savedWorkExperience);
        savedWorkExperience.setRoles(savedRoles);
        savedWorkExperience.setUser(user);
        return workExperienceRepository.save(savedWorkExperience);
    }

    private Skills updateSkills(UserCreationDTO userCreationDTO, User user) {
        Skills skills = skillsRepository.findByUser(user);
        List<Skill> updatedSoftSkills = updateSkills(userCreationDTO.getSkills().getSoft(), skills, user, "soft");
        List<Skill> updatedHardSkills = updateSkills(userCreationDTO.getSkills().getHard(), skills, user, "hard");
        skills.setSoft(updatedSoftSkills);
        skills.setHard(updatedHardSkills);
        skills.setUser(user);
        return skillsRepository.save(skills);
    }

    private List<Skill> updateSkills(List<? extends SkillDTO> skillDTOs, Skills skills, User user, String type) {
        List<Skill> savedSkills;

        if (Objects.equals(type, "hard")) {
            savedSkills = skills.getHard();
        } else {
            savedSkills = skills.getSoft();
        }

        for (SkillDTO skillDTO : skillDTOs) {
            Skill skill;
            if (savedSkills.isEmpty()) {
                skill = new Skill();
            } else {
                skill = savedSkills.get(0);
                savedSkills.remove(0);
            }

            skill.setName(skillDTO.getName());
            skill.setDescription(skillDTO.getDescription());
            skill.setAbilities(skillDTO.getAbilities());
            skill.setBackground(skillDTO.getBackground());
            skill.setLevel(skillDTO.getLevel());
            skill.setUser(user);

            savedSkills.add(skill);
            skillRepository.save(skill);
        }

        return savedSkills;
    }

    // SAVES
    private User createUserWithDefaultValues() {
        User user = new User();
        user.setFirstName("Gem");
        user.setLastName("De Castro");
        user.setEmailAddress("gemdelle@outlook.com");
        user.setPassword("1234");
        return user;
    }

    private About saveAbout(AboutDTO aboutDTO, User user) {
        About about = new About();
        about.setBannerUrl(aboutDTO.getBanner_url());
        about.setCreativityDescription(aboutDTO.getCreativity_description());
        about.setLogicDescription(aboutDTO.getLogic_description());
        about.setProfilePictureUrl(aboutDTO.getProfile_picture_url());
        about.setProfileTitle(aboutDTO.getProfile_title());
        about.setUser(user);
        return aboutRepository.save(about);
    }

    private List<Institution> saveInstitutions(List<InstitutionDTO> institutionDTOs, Education education) {
        List<Institution> savedInstitutions = new ArrayList<>();
        for (InstitutionDTO institutionDTO : institutionDTOs) {
            Institution institution = new Institution();
            institution.setCertificate(institutionDTO.getCertificate());
            institution.setName(institutionDTO.getName());
            institution.setLogo(institutionDTO.getLogo());
            institution.setTitle(institutionDTO.getTitle());
            institution.setFrom_date(institutionDTO.getFrom());
            institution.setTo_date(institutionDTO.getTo());
            institution.setEducation(education);
            Institution savedInstitution = institutionRepository.save(institution);
            savedInstitutions.add(savedInstitution);
        }
        return savedInstitutions;
    }

    private List<Language> saveLanguages(List<LanguageDTO> languageDTOs, Education education) {
        List<Language> savedLanguages = new ArrayList<>();
        for (LanguageDTO languageDTO : languageDTOs) {
            Language language = new Language();
            language.setName(languageDTO.getName());
            language.setCertificate(languageDTO.getCertificate());
            language.setBackgroundD(languageDTO.getBackground());
            language.setLevel(languageDTO.getLevel());
            language.setTitle(languageDTO.getTitle());
            language.setFull(languageDTO.getFull());
            language.setEmptyD(languageDTO.getEmpty());
            language.setEducation(education);
            Language savedLanguage = languageRepository.save(language);
            savedLanguages.add(savedLanguage);
        }
        return savedLanguages;
    }

    private Education saveEducation(UserCreationDTO userCreationDTO, User user) {
        Education education = new Education();
        List<Institution> savedInstitutions = saveInstitutions(userCreationDTO.getEducation().getInstitutions(), education);
        List<Language> savedLanguages = saveLanguages(userCreationDTO.getEducation().getLanguages(), education);

        education.setInstitutions(savedInstitutions);
        education.setLanguages(savedLanguages);
        education.setUser(user);
        return educationRepository.save(education);
    }

    private List<Course> saveCourses(List<CourseDTO> courseDTOs, Academy academy) {
        List<Course> savedCourses = new ArrayList<>();
        for (CourseDTO courseDTO : courseDTOs) {
            Course course = new Course();
            course.setName(courseDTO.getName());
            course.setCertificate(courseDTO.getCertificate());
            course.setDescription(courseDTO.getDescription());
            Course savedCourse = courseRepository.save(course);
            savedCourse.setAcademy(academy);
            savedCourses.add(savedCourse);
        }
        return savedCourses;
    }

    private List<Academy> saveAcademies(List<AcademyDTO> academyDTOs, User user) {
        List<Academy> savedAcademies = new ArrayList<>();
        for (AcademyDTO academyDTO : academyDTOs) {
            Academy academy = new Academy();
            List<Course> savedCourses = saveCourses(academyDTO.getCourses(), academy);
            academy.setName(academyDTO.getName());
            academy.setLogo(academyDTO.getLogo());
            academy.setShield(academyDTO.getShield());
            academy.setCourses(savedCourses);
            academy.setUser(user);
            Academy savedAcademy = academyRepository.save(academy);
            savedAcademies.add(savedAcademy);
        }
        return savedAcademies;
    }

    private List<Project> saveProjects(List<ProjectDTO> projectDTOs, User user) {
        List<Project> savedProjects = new ArrayList<>();
        for (ProjectDTO projectDTO : projectDTOs) {
            Project project = new Project();
            project.setTitle(projectDTO.getTitle());
            project.setProjectUrl(projectDTO.getData().getProject_url());
            project.setType(projectDTO.getType());
            project.setNumber(String.valueOf(projectDTO.getNumber()));
            project.setDescription(projectDTO.getDescription());
            project.setTags(projectDTO.getTags());
            project.setBackground(projectDTO.getData().getBackground());
            project.setSubprojects(saveSubprojects(projectDTO.getData().getSubprojects()));
            project.setUser(user);
            Project savedProject = projectRepository.save(project);
            savedProjects.add(savedProject);
        }
        return savedProjects;
    }

    private List<Subproject> saveSubprojects(List<SubprojectDTO> subprojectsDTOs){
        if(subprojectsDTOs == null || subprojectsDTOs.isEmpty()){
            return Collections.emptyList();
        }

        List<Subproject> subprojects = new ArrayList<>();
        for(SubprojectDTO  subprojectDTO : subprojectsDTOs){
            Subproject subproject = new Subproject();
            subproject.setBackground(subprojectDTO.getBackground());
            subproject.setName(subprojectDTO.getName());
            subproject.setNumber(subprojectDTO.getNumber());
            subproject.setFccStyleUrl(subprojectDTO.getFcc_style_url());
            subproject.setFccStyleDescription(subprojectDTO.getFcc_style_description());
            subproject.setMyStyleUrl(subprojectDTO.getMy_style_url());
            subproject.setMyStyleDescription(subprojectDTO.getMy_style_description());
            subprojects.add(subproject);
        }

        return subprojects;
    }

    private List<Role> saveRoles(List<RoleDTO> roleDTOs, WorkExperience workExperience) {
        List<Role> savedRoles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOs) {
            Role role = new Role();
            role.setName(roleDTO.getName());
            role.setDescription(roleDTO.getDescription());
            role.setWorkExperience(workExperience);
            Role savedRole = roleRepository.save(role);
            savedRoles.add(savedRole);
        }
        return savedRoles;
    }

    private WorkExperience saveWorkExperiences(ExperienceDTO workExperienceDTO, User user) {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setLogo(workExperienceDTO.getLogo());
        workExperience.setDescription(workExperienceDTO.getDescription());
        workExperience.setStartDate(workExperienceDTO.getFrom());
        workExperience.setEndDate(workExperienceDTO.getTo());
        workExperience.setStudioName(workExperienceDTO.getStudio_name());
        workExperience.setThumbnail(workExperienceDTO.getThumbnail());
        workExperience.setThumbnailUrl(workExperienceDTO.getThumbnail_url());

        List<Role> savedRoles = saveRoles(workExperienceDTO.getRoles(), workExperience);
        workExperience.setRoles(savedRoles);
        workExperience.setUser(user);
        workExperienceRepository.save(workExperience);

        return workExperience;
    }

    private Skills saveSkills(List<Skill> softSkills, List<Skill> hardSkills, User user) {
        Skills skills = new Skills();
        skills.setSoft(softSkills);
        skills.setHard(hardSkills);
        skills.setUser(user);
        return skillsRepository.save(skills);
    }

    private List<Skill> saveSkills(List<? extends SkillDTO> skillDTOs, User user) {
        List<Skill> savedSkills = new ArrayList<>();
        for (SkillDTO skillDTO : skillDTOs) {
            Skill skill = new Skill();
            skill.setName(skillDTO.getName());
            skill.setDescription(skillDTO.getDescription());
            skill.setAbilities(skillDTO.getAbilities());
            skill.setBackground(skillDTO.getBackground());
            skill.setLevel(skillDTO.getLevel());
            skill.setUser(user);
            Skill savedSkill = skillRepository.save(skill);
            savedSkills.add(savedSkill);
        }
        return savedSkills;
    }

    private void setUserDetails(User user, About about, Education education, List<Academy> academies,
                                List<Project> projects, WorkExperience workExperience, Skills skills) {
        user.setAbout(about);
        user.setEducation(education);
        user.setAcademies(academies);
        user.setProjects(projects);
        user.setWorkExperience(workExperience);
        user.setSkills(skills);
    }
}
