<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountForumCommentsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountForumCommentsTable Test Case
 */
class CountForumCommentsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountForumCommentsTable
     */
    public $CountForumComments;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_forum_comments'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountForumComments') ? [] : ['className' => CountForumCommentsTable::class];
        $this->CountForumComments = TableRegistry::get('CountForumComments', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountForumComments);

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
