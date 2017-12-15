<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\LastNewUsersTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\LastNewUsersTable Test Case
 */
class LastNewUsersTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\LastNewUsersTable
     */
    public $LastNewUsers;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.last_new_users'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('LastNewUsers') ? [] : ['className' => LastNewUsersTable::class];
        $this->LastNewUsers = TableRegistry::get('LastNewUsers', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->LastNewUsers);

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
