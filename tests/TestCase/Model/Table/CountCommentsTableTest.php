<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountCommentsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountCommentsTable Test Case
 */
class CountCommentsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountCommentsTable
     */
    public $CountComments;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_comments'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountComments') ? [] : ['className' => CountCommentsTable::class];
        $this->CountComments = TableRegistry::get('CountComments', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountComments);

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
