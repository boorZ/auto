<#--<#if classPath??>-->
<#--package ${classPath};-->
<#--</#if>-->
<#--${imports}-->

@Entity
@Data
@Table(name = "${className}")
public class ${fileName} extends BaseEntity{
<#--public class ${fileName} {-->

<#list newMember as m>
    @Column(name = "${m.conlumName}")
    private ${m.conlumTypeName} ${m.humpConlumName ? uncap_first};

</#list>
<#list newMember as m>
    public ${m.conlumTypeName} get${m.humpConlumName}() {
        return ${m.humpConlumName ? uncap_first};
    }

    public void set${m.humpConlumName}(${m.conlumTypeName} ${m.humpConlumName ? uncap_first}) {
        this.${m.humpConlumName ? uncap_first} = ${m.humpConlumName ? uncap_first};
    }

</#list>
    public ${fileName}() {
    }

    public ${fileName}(<#list newMember as m>${m.conlumTypeName} ${m.humpConlumName ? uncap_first}<#if m_has_next>,</#if></#list> ) {
        <#list newMember as m>
            this.${m.humpConlumName ? uncap_first} = ${m.humpConlumName ? uncap_first};
        </#list>
    }
}