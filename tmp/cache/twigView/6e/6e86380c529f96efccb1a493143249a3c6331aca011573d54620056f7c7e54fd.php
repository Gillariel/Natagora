<?php

/* C:\Users\foers\Downloads\cakephp\NataWeb\vendor\cakephp\bake\src\Template\Bake\tests\fixture.twig */
class __TwigTemplate_2be46df0f464d37dc888e731f1eee350844e39168f9f6f3d1c72376dc048a695 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_a3de982d74515c0dc92689a8516e00c5e2e444506c45301a416079552c3d3a93 = $this->env->getExtension("WyriHaximus\\TwigView\\Lib\\Twig\\Extension\\Profiler");
        $__internal_a3de982d74515c0dc92689a8516e00c5e2e444506c45301a416079552c3d3a93->enter($__internal_a3de982d74515c0dc92689a8516e00c5e2e444506c45301a416079552c3d3a93_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "C:\\Users\\foers\\Downloads\\cakephp\\NataWeb\\vendor\\cakephp\\bake\\src\\Template\\Bake\\tests\\fixture.twig"));

        // line 20
        echo "<?php
namespace ";
        // line 21
        echo twig_escape_filter($this->env, (isset($context["namespace"]) ? $context["namespace"] : null), "html", null, true);
        echo "\\Test\\Fixture;

use Cake\\TestSuite\\Fixture\\TestFixture;

/**
 * ";
        // line 26
        echo twig_escape_filter($this->env, (isset($context["name"]) ? $context["name"] : null), "html", null, true);
        echo "Fixture
 *
 */
class ";
        // line 29
        echo twig_escape_filter($this->env, (isset($context["name"]) ? $context["name"] : null), "html", null, true);
        echo "Fixture extends TestFixture
{
";
        // line 31
        if ((isset($context["table"]) ? $context["table"] : null)) {
            // line 32
            echo "
    /**
     * Table name
     *
     * @var string
     */
    public \$table = '";
            // line 38
            echo (isset($context["table"]) ? $context["table"] : null);
            echo "';
";
        }
        // line 41
        if ((isset($context["import"]) ? $context["import"] : null)) {
            // line 42
            echo "
    /**
     * Import
     *
     * @var array
     */
    public \$import = ";
            // line 48
            echo (isset($context["import"]) ? $context["import"] : null);
            echo ";
";
        }
        // line 51
        if ((isset($context["schema"]) ? $context["schema"] : null)) {
            // line 52
            echo "
    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public \$fields = ";
            // line 59
            echo (isset($context["schema"]) ? $context["schema"] : null);
            echo ";
    // @codingStandardsIgnoreEnd
";
        }
        // line 63
        if ((isset($context["records"]) ? $context["records"] : null)) {
            // line 64
            echo "
    /**
     * Records
     *
     * @var array
     */
    public \$records = ";
            // line 70
            echo (isset($context["records"]) ? $context["records"] : null);
            echo ";
";
        }
        // line 72
        echo "}
";
        
        $__internal_a3de982d74515c0dc92689a8516e00c5e2e444506c45301a416079552c3d3a93->leave($__internal_a3de982d74515c0dc92689a8516e00c5e2e444506c45301a416079552c3d3a93_prof);

    }

    public function getTemplateName()
    {
        return "C:\\Users\\foers\\Downloads\\cakephp\\NataWeb\\vendor\\cakephp\\bake\\src\\Template\\Bake\\tests\\fixture.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  106 => 72,  101 => 70,  93 => 64,  91 => 63,  85 => 59,  76 => 52,  74 => 51,  69 => 48,  61 => 42,  59 => 41,  54 => 38,  46 => 32,  44 => 31,  39 => 29,  33 => 26,  25 => 21,  22 => 20,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{#
/**
 * Fixture Template file
 *
 * Fixture Template used when baking fixtures with bake
 *
 * CakePHP(tm) : Rapid Development Framework (http://cakephp.org)
 * Copyright (c) Cake Software Foundation, Inc. (http://cakefoundation.org)
 *
 * Licensed under The MIT License
 * For full copyright and license information, please see the LICENSE.txt
 * Redistributions of files must retain the above copyright notice.
 *
 * @copyright     Copyright (c) Cake Software Foundation, Inc. (http://cakefoundation.org)
 * @link          http://cakephp.org CakePHP(tm) Project
 * @since         2.0.0
 * @license       http://www.opensource.org/licenses/mit-license.php MIT License
 */
#}
<?php
namespace {{ namespace }}\\Test\\Fixture;

use Cake\\TestSuite\\Fixture\\TestFixture;

/**
 * {{ name }}Fixture
 *
 */
class {{ name }}Fixture extends TestFixture
{
{% if table %}

    /**
     * Table name
     *
     * @var string
     */
    public \$table = '{{ table|raw }}';
{% endif %}

{%- if import %}

    /**
     * Import
     *
     * @var array
     */
    public \$import = {{ import|raw }};
{% endif %}

{%- if schema %}

    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public \$fields = {{ schema|raw }};
    // @codingStandardsIgnoreEnd
{% endif %}

{%- if records %}

    /**
     * Records
     *
     * @var array
     */
    public \$records = {{ records|raw }};
{% endif %}
}
", "C:\\Users\\foers\\Downloads\\cakephp\\NataWeb\\vendor\\cakephp\\bake\\src\\Template\\Bake\\tests\\fixture.twig", "");
    }
}
