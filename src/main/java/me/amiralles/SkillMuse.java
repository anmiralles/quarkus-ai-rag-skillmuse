package me.amiralles;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.inject.Singleton;

@RegisterAiService
@Singleton
public interface SkillMuse {

    @SystemMessage("<<SYS>>You are Skill Muse, an AI bot answering questions about differentiating skills " +
            "between developers and sysadmins roles.<</SYS>>")
    @UserMessage("""
        The question can be in any language. So, you will need to identify the language.
        The answer must be polite, and be relevant to the question.
        The answer must not have more than 30 words. Answer with the suggested role either developer or sysadmin and possible tasks to execute.
        
        +++
        {question}
        +++
        """)
    String chat(@MemoryId Object session, String question);
}
