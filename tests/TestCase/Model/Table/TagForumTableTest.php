<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\TagForumTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\TagForumTable Test Case
 */
class TagForumTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\TagForumTable
     */
    public $TagForum;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.tag_forum'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('TagForum') ? [] : ['className' => TagForumTable::class];
        $this->TagForum = TableRegistry::get('TagForum', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->TagForum);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
